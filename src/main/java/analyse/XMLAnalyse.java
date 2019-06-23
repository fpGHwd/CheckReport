/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-18
 * @Time: 下午3:27
 * @Project: CheckReport
 */

package analyse;

import dao.*;
import entity.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONObject;
import org.junit.Test;
import service.CheckSummaryImpl;
import service.CheckSummaryService;
import service.SystemInfoImpl;
import service.SystemInfoService;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLAnalyse {

    public static Map<String, Object> map;
    private static List<File> files;
    private static JSONObject jsonObject;

    static {
        URL resource = XMLAnalyse.class.getResource("/");
        String path = resource.getPath();
        files = getXMLfiles(path);
        try {
            jsonObject = new JSONObject(FileUtils.readFile(path + "settings.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        map = jsonObject.toMap();
    }

    /**
     * 获取文件
     *
     * @param filesPath
     * @return
     */
    public static List<File> getXMLfiles(String filesPath) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(filesPath);
        File[] files = file.listFiles();
        Pattern p = Pattern.compile("\\d{14}");
        for (File f : files) {
            Matcher matcher = p.matcher(f.getName());
            if (matcher.find()) {
                String dateStr = matcher.group();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddkkmmss");
                Date d = null;
                try {
                    d = dateFormat.parse(dateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("文件的创建时间为：" + d);
                fileList.add(f);
            }
        }
        return fileList;
    }

    /**
     * 解析一个xml文件
     *
     * @param file
     */
    public static void anaysisFile(File file) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        int i = 0;
        List<Element> childElements = document.getRootElement().elements();
        for (Element ele : childElements) {
            if(ele.elements() == null)continue; // 如果没有
            if ("System".equals(ele.getName())) {
                try {
                    saveSystem(ele);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if ("Ied".equals(ele.getName())) {
                List<Element> childElements1 = ele.elements();
                for (Element e : childElements1) {
                    saveIed(e);
                }
            } else {
                saveOtherItems(ele);
            }

        }
    }

    /**
     * 解析出节点System的信息并存储
     *
     * @param ele
     * @throws ParseException
     */
    public static void saveSystem(Element ele) throws ParseException {
        String substation = ele.elementText("Substation");
        String checkTime = ele.elementText("CheckTime");   // 2019-05-25T11:56:32
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
        Date d = dateFormat.parse(checkTime);
        String checkReason = ele.elementText("CheckReason");
        int checkReasonInt = Integer.parseInt(checkReason);
        String deviceSum = ele.elementText("DeviceSum");
        int deviceSumInt = Integer.parseInt(deviceSum);
        String checkDeviceSum = ele.elementText("CheckDeviceSum");
        int checkDeviceSumInt = Integer.parseInt(checkDeviceSum);
        String abnormalDeviceSum = ele.elementText("AbnormalDeviceSum");
        int abnormalDeviceSumInt = Integer.parseInt(abnormalDeviceSum);
        TbSystemEntity tse = new TbSystemEntity();
        tse.setSubstation(substation);
        tse.setCheckTime(new java.sql.Date(d.getTime()));
        tse.setCheckReason(checkReasonInt);
        tse.setDeviceSum(deviceSumInt);
        tse.setCheckDeviceSum(checkDeviceSumInt);
        tse.setAbnormalDeviceSum(abnormalDeviceSumInt);

        SystemInfoService sis = new SystemInfoImpl();
        sis.saveSystemInfoService(tse);

    }

    public static void saveIed(Element ele) {
        TbCheckSummaryEntity tcse = new TbCheckSummaryEntity();
        String deviceId = ele.attributeValue("DeviceId");
        String deviceName = ele.attributeValue("DeviceName");
        byte isChecked = (byte) ("1".equals(ele.attributeValue("IsChecked")) ? 1 : 0);
        Integer uncheckReason = Integer.parseInt(ele.attributeValue("UnCheckReason"));
        Integer result = Integer.parseInt(ele.attributeValue("Result"));
        tcse.setDeviceId(deviceId);
        tcse.setDeviceName(deviceName);
        tcse.setIsChecked(isChecked);
        tcse.setUnCheckReason(uncheckReason);
        tcse.setResult(result);
        List<Element> childElements = ele.elements();
        String cn;
        byte isCheckedChild, uncheckReasonChild, resultChild;
        CheckSummaryService css = new CheckSummaryImpl();
        for (Element e : childElements) {
            if(e.elements() == null)continue; // 如果没有元素，比如switch元素
            cn = e.getName();
            isCheckedChild = Byte.parseByte(e.attributeValue("IsChecked"));
            uncheckReasonChild = Byte.parseByte(e.attributeValue("UnCheckReason"));
            resultChild = Byte.parseByte(e.attributeValue("Result"));
            if ("Zone".equals(cn)) {
                tcse.setZoneIsChecked(isCheckedChild);
                tcse.setZoneUncheckReason(uncheckReasonChild);
                tcse.setZoneResult(resultChild);
            } else if ("Setting".equals(cn)) {
                tcse.setSettingIsChecked(isCheckedChild);
                tcse.setSettingUncheckReason(uncheckReasonChild);
                tcse.setSettingResult(resultChild);
            } else if ("SoftPlate".equals(cn)) {
                tcse.setSoftPlateIsChecked(isCheckedChild);
                tcse.setSoftPlateUncheckReason(uncheckReasonChild);
                tcse.setSoftPlateResult(resultChild);
            } else if ("HardPlate".equals(cn)) {
                tcse.setHardPlateIsChecked(isCheckedChild);
                tcse.setHardPlateUncheckReason(uncheckReasonChild);
                tcse.setHardPlateResult(resultChild);
            } else if ("Discrete".equals(cn)) {
                tcse.setDiscreteIsChecked(isCheckedChild);
                tcse.setDiscreteUncheckReason(uncheckReasonChild);
                tcse.setDiscreteResult(resultChild);
            } else if ("Clock".equals(cn)) {
                tcse.setClockIsChecked(isCheckedChild);
                tcse.setClockUncheckReason(uncheckReasonChild);
                tcse.setClockResult(resultChild);
            } else if ("CommStatus".equals(cn)) {
                tcse.setCommStatusIsChecked(isCheckedChild);
                tcse.setCommStatusUncheckReason(uncheckReasonChild);
                tcse.setCommStatusResult(resultChild);
            } else if ("SecCircuit".equals(cn)) {
                tcse.setSecCircuitIsChecked(isCheckedChild);
                tcse.setSecCircuitUncheckReason(uncheckReasonChild);
                tcse.setSecCircuitResult(resultChild);
            } else if ("SoftVersion".equals(cn)) {
                tcse.setSoftVersionIsChecked(isCheckedChild);
                tcse.setSoftVersionUncheckReason(uncheckReasonChild);
                tcse.setSoftVersionResult(resultChild);
            } else if ("SelfAlarm".equals(cn)) {
                tcse.setSelfAlarmIsChecked(isCheckedChild);
                tcse.setSelfAlarmUncheckReason(uncheckReasonChild);
                tcse.setSelfAlarmResult(resultChild);
            } else if ("GpsAlarm".equals(cn)) {
                tcse.setGpsAlarmIsChecked(isCheckedChild);
                tcse.setGpsAlarmUncheckReason(uncheckReasonChild);
                tcse.setGpsAlarmResult(resultChild);
            } else if ("Wave".equals(cn)) {
                tcse.setWaveIsChecked(isCheckedChild);
                tcse.setWaveUncheckReason(uncheckReasonChild);
                tcse.setWaveResult(resultChild);
            } else if ("Analog".equals(cn)) {
                tcse.setAnalogIsChecked(isCheckedChild);
                tcse.setAnalogUncheckReason(uncheckReasonChild);
                tcse.setAnalogResult(resultChild);
            } else if ("Loop".equals(cn)) {
                tcse.setLoopIsChecked(isCheckedChild);
                tcse.setLoopUncheckReason(uncheckReasonChild);
                tcse.setLoopResult(resultChild);
            } else if ("Channel".equals(cn)) {
                tcse.setChannelIsChecked(isCheckedChild);
                tcse.setChannelUncheckReason(uncheckReasonChild);
                tcse.setChannelResult(resultChild);
            } else { // Switch
                tcse.setSwitchIsChecked(isCheckedChild);
                tcse.setSwitchUncheckReason(uncheckReasonChild);
                tcse.setSwitchResult(resultChild);
            }
        }
        css.saveCheckSummary(tcse);
    }

    public static void saveOtherItems(Element ele) {
        List<Element> childElements = ele.elements();
        if (childElements == null) return;

        if ("DiffZone".equals(ele.getName())) {
            TbCheckDiffZoneEntity tcdze = new TbCheckDiffZoneEntity();
            DiffZoneDao dzd = new DiffZoneImpl();
            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");
                String refValStr = e.attributeValue("RefVal");
                Integer refVal = Integer.parseInt(("".equals(refValStr)) ? "-1" : refValStr);
                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt("".equals(realValStr) ? "-1" : realValStr);

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdze.setDeviceId(deviceId);
                tcdze.setPointName(pointName);
                tcdze.setValType(valType);
                tcdze.setRefType(refVal);
                tcdze.setRealVal(realVal);
                tcdze.setCheckTime(checkTime);
                tcdze.setIsDifferent(isDifferent);
                dzd.saveDiffZone(tcdze);
            }
        } else if ("DiffSetting".equals(ele.getName())) {

            TbCheckDiffSettingsEntity tcdse = new TbCheckDiffSettingsEntity();
            DiffSettingDao dsd = new DiffSettingImpl();
            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");
                String refVal = e.attributeValue("RefVal");
                String realVal = (e.attributeValue("RealVal"));

                String zoneNoStr = e.attributeValue("ZoneNo");
                Integer zoneNo = Integer.parseInt("".equals(zoneNoStr) ? "-1" : zoneNoStr);

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdse.setDeviceId(deviceId);
                tcdse.setPointId(pointId);
                tcdse.setPointName(pointName);
                tcdse.setValType(valType);
                tcdse.setRefVal(refVal);
                tcdse.setRealVal(realVal);
                tcdse.setZoneNo(zoneNo);
                tcdse.setCheckTime(checkTime);
                tcdse.setIsDifferent(isDifferent);
                dsd.saveDiffSetting(tcdse);
            }

        } else if ("DiffSoftPlate".equals(ele.getName())) {
            TbCheckDiffSoftPlateEntity tcdsp = new TbCheckDiffSoftPlateEntity();
            DiffSoftPlateDao dspd = new DiffSoftPlateImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");

                String refValStr = e.attributeValue("RefVal");
                Integer refVal = Integer.parseInt(("".equals(refValStr)) ? "-1" : refValStr);
                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt("".equals(realValStr) ? "-1" : realValStr);
                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdsp.setDeviceId(deviceId);
                tcdsp.setPointId(pointId);
                tcdsp.setPointName(pointName);
                tcdsp.setValType(valType);
                tcdsp.setRefVal(refVal);
                tcdsp.setRealVal(realVal);
                tcdsp.setCheckTime(checkTime);
                tcdsp.setIsDifferent(isDifferent);
                dspd.saveDiffSoftPlate(tcdsp);
            }
        } else if ("DiffHardPlate".equals(ele.getName())) {
            TbCheckDiffHardPlateEntity tcdhp = new TbCheckDiffHardPlateEntity();
            DiffHardPlateDao dhpd = new DiffHardPlateImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");

                String refValStr = e.attributeValue("RefVal");
                Integer refVal = Integer.parseInt(("".equals(refValStr)) ? "-1" : refValStr);
                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt("".equals(realValStr) ? "-1" : realValStr);
                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdhp.setDeviceId(deviceId);
                tcdhp.setPointId(pointId);
                tcdhp.setPointName(pointName);
                tcdhp.setValType(valType);
                tcdhp.setRefVal(refVal);
                tcdhp.setRealVal(realVal);
                tcdhp.setCheckTime(checkTime);
                tcdhp.setIsDifferent(isDifferent);
                dhpd.saveDiffHardPlate(tcdhp);
            }

        } else if ("DiffDiscrete".equals(ele.getName())) {

            TbCheckDiffDiscreteEntity tcdde = new TbCheckDiffDiscreteEntity();
            DiffDiscreteDao ddd = new DiffDiscreteImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");

                String refValStr = e.attributeValue("RefVal");
                Integer refVal = Integer.parseInt(("".equals(refValStr)) ? "-1" : refValStr);
                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt("".equals(realValStr) ? "-1" : realValStr);
                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdde.setDeviceId(deviceId);
                tcdde.setPointId(pointId);
                tcdde.setPointName(pointName);
                tcdde.setValType(valType);
                tcdde.setRefVal(refVal);
                tcdde.setRealVal(realVal);
                tcdde.setCheckTime(checkTime);
                tcdde.setIsDifferent(isDifferent);
                ddd.saveDiffDiscrete(tcdde);
            }

        } else if ("DiffClock".equals(ele.getName())) {
            TbCheckDiffClockEntity tcdce = new TbCheckDiffClockEntity();
            DiffClockDao dcd = new DiffClockImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");

                java.sql.Date refVal = null, realVal = null, checkTime = null;
                try {
                    String refValStr = e.attributeValue("RefVal");
                    if ("".equals(refValStr)) {
                        refVal = null;
                    } else
                        refVal = timeFormatter(refValStr);
                    String realValStr = e.attributeValue("RealVal");
                    if ("".equals(realValStr)) {
                        realVal = null;
                    } else
                        realVal = timeFormatter(realValStr);
                    String checkTimeValStr = e.attributeValue("CheckTime");
                    checkTime = timeFormatter(checkTimeValStr);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdce.setDeviceId(deviceId);
                tcdce.setPointName(pointName);
                tcdce.setValType(valType);
                tcdce.setRefVal(refVal);
                tcdce.setRealVal(realVal);
                tcdce.setCheckTime(checkTime);
                tcdce.setIsDifferent(isDifferent);
                dcd.saveDiffClock(tcdce);
            }

        } else if ("CommStatus".equals(ele.getName())) {

            TbCheckDiffCommStatusEntity tcdcde = new TbCheckDiffCommStatusEntity();
            DiffCommStatusDao ddsd = new DiffCommStatusImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointName = e.attributeValue("PointName");

                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt("".equals(realValStr) ? "-1" : realValStr);
                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdcde.setDeviceId(deviceId);
                tcdcde.setPointName(pointName);
                tcdcde.setRealVal(realVal);
                tcdcde.setCheckTime(checkTime);
                tcdcde.setIsDifferent(isDifferent);
                ddsd.saveDiffCommStatus(tcdcde);
            }

        } else if ("SecCircuit".equals(ele.getName())) {

            TbCheckDiffSecCircuitEntity tcdsce = new TbCheckDiffSecCircuitEntity();
            DiffSecCircuitDao dscd = new DiffSecCircuitImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");

                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt("".equals(realValStr) ? "-1" : realValStr);
                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdsce.setDeviceId(deviceId);
                tcdsce.setPointId(pointId);
                tcdsce.setPointName(pointName);
                tcdsce.setRealVal(realVal);
                tcdsce.setCheckTime(checkTime);
                tcdsce.setIsDifferent(isDifferent);
                dscd.saveDiffSecCircuit(tcdsce);
            }

        } else if ("SoftVersion".equals(ele.getName())) {


            TbCheckDiffSoftVersionEntity tcdsve = new TbCheckDiffSoftVersionEntity();
            DiffSoftVersionDao dsvd = new DiffSoftVersionImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String refVal = e.attributeValue("RefVal");
                String realVal = e.attributeValue("RealVal");

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdsve.setDeviceId(deviceId);
                tcdsve.setPointId(pointId);
                tcdsve.setPointName(pointName);
                tcdsve.setRefVal(refVal);
                tcdsve.setRealVal(realVal);
                tcdsve.setCheckTime(checkTime);
                tcdsve.setIsDifferent(isDifferent);
                dsvd.saveDiffSoftVersion(tcdsve);
            }

        } else if ("SelfAlarm".equals(ele.getName())) {

            TbCheckDiffSelfAlarmEntity tcdsae = new TbCheckDiffSelfAlarmEntity();
            DiffSelfAlarmDao dsad = new DiffSelfAlarmImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt(("".equals(realValStr)) ? "-1" : realValStr);

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdsae.setDeviceId(deviceId);
                tcdsae.setPointId(pointId);
                tcdsae.setPointName(pointName);
                tcdsae.setRealVal(realVal);
                tcdsae.setCheckTime(checkTime);
                tcdsae.setIsDifferent(isDifferent);
                dsad.saveSelfAlarm(tcdsae);
            }

        } else if ("GpsAlarm".equals(ele.getName())) {

            TbCheckDiffGpsAlarmEntity tcdgae = new TbCheckDiffGpsAlarmEntity();
            DiffGpsAlarmDao dgad = new DiffGpsAlarmImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt(("".equals(realValStr)) ? "-1" : realValStr);

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdgae.setDeviceId(deviceId);
                tcdgae.setPointId(pointId);
                tcdgae.setPointName(pointName);
                tcdgae.setRealVal(realVal);
                tcdgae.setCheckTime(checkTime);
                tcdgae.setIsDifferent(isDifferent);
                dgad.saveGpsAlarm(tcdgae);
            }

        } else if ("Wave".equals(ele.getName())) {

            TbCheckDiffWaveEntity tcdwe = new TbCheckDiffWaveEntity();
            DiffWaveDao dwd = new DiffWaveImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String realVal = e.attributeValue("RealVal");

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdwe.setDeviceId(deviceId);
                tcdwe.setRealVal(realVal);
                tcdwe.setCheckTime(checkTime);
                tcdwe.setIsDifferent(isDifferent);
                dwd.saveWave(tcdwe);
            }

        } else if ("DiffAnalog".equals(ele.getName())) {

            TbCheckDiffAnalogEntity tcdae = new TbCheckDiffAnalogEntity();
            DiffAnalogDao dad = new DiffAnalogImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");
                String realValStr = e.attributeValue("RealVal");
                Double realVal = Double.parseDouble(("".equals(realValStr)) ? "-1" : realValStr);
                String lowerLimitStr = e.attributeValue("LowerLimit");
                Double lowerLimit = Double.parseDouble(("".equals(lowerLimitStr)) ? "-1" : lowerLimitStr);
                String upperLimitStr = e.attributeValue("UpperLimit");
                Double upperLimit = Double.parseDouble(("".equals(upperLimitStr)) ? "-1" : upperLimitStr);

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdae.setDeviceId(deviceId);
                tcdae.setPointId(pointId);
                tcdae.setPointName(pointName);
                tcdae.setValType(valType);
                tcdae.setRealVal(realVal);
                tcdae.setLowerLimit(lowerLimit);
                tcdae.setUpperLimit(upperLimit);
                tcdae.setCheckTime(checkTime);
                tcdae.setIsDifferent(isDifferent);
                dad.saveAnalog(tcdae);
            }

        } else if ("Loop".equals(ele.getName())) {
            TbCheckDiffLoopEntity tcdle = new TbCheckDiffLoopEntity();
            DiffLoopDao dld = new DiffLoopImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String valType = e.attributeValue("ValType");
                String realValStr = e.attributeValue("RealVal");
                Double realVal = Double.parseDouble(("".equals(realValStr)) ? "-1" : realValStr);
                String lowerLimitStr = e.attributeValue("LowerLimit");
                Double lowerLimit = Double.parseDouble(("".equals(lowerLimitStr)) ? "-1" : lowerLimitStr);
                String upperLimitStr = e.attributeValue("UpperLimit");
                Double upperLimit = Double.parseDouble(("".equals(upperLimitStr)) ? "-1" : upperLimitStr);

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));

                tcdle.setDeviceId(deviceId);
                tcdle.setPointId(pointId);
                tcdle.setPointName(pointName);
                tcdle.setValType(valType);
                tcdle.setRealVal(realVal);
                tcdle.setLowerLimit(lowerLimit);
                tcdle.setUpperLimit(upperLimit);
                tcdle.setCheckTime(checkTime);
                tcdle.setIsDifferent(isDifferent);
                dld.saveLoop(tcdle);
            }

        } else if ("Channel".equals(ele.getName())) {


            TbCheckDiffChannelEntity tcdce = new TbCheckDiffChannelEntity();
            DiffChannelDao dcd = new DiffChannelImpl();

            for (Element e : childElements) {
                String deviceId = e.attributeValue("DeviceId");
                String pointId = e.attributeValue("PointId");
                String pointName = e.attributeValue("PointName");
                String realValStr = e.attributeValue("RealVal");
                Integer realVal = Integer.parseInt(("".equals(realValStr)) ? "-1" : realValStr);

                java.sql.Date checkTime = null;
                try {
                    checkTime = timeFormatter(e.attributeValue("CheckTime"));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Byte isDifferent = Byte.parseByte(e.attributeValue("IsDifferent"));


                tcdce.setDeviceId(deviceId);
                tcdce.setPointId(pointId);
                tcdce.setPointName(pointName);
                tcdce.setRealVal(realVal);
                tcdce.setCheckTime(checkTime);
                tcdce.setIsDifferent(isDifferent);
                dcd.saveChannel(tcdce);
            }
        } else { // Switch
            return;
        }
    }

    public static void main(String[] args) {
        if (files == null) {
            System.out.println("files is null");
            return;
        }
        int i = 0;
        for (File f : files) {
            long startTime = System.currentTimeMillis();
            System.out.print("开始处理第"+(++i)+"张表");
            anaysisFile(f);
            long endTime = System.currentTimeMillis();
            System.out.println("完成处理第"+(i)+"张表，耗时" + (endTime-startTime)/1000 + "秒");
        }
    }

    @Test
    public void testTime() {
        String timeStr = "2019-05-25T11:56:32";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
        Date d = null;
        try {
            d = dateFormat.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
    }

    public static java.sql.Date timeFormatter(String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
        Date d = dateFormat.parse(time);
        return new java.sql.Date(d.getTime());
    }

}
