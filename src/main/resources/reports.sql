USE report;

CREATE TABLE IF NOT EXISTS tb_system
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    substation        VARCHAR(64) NOT NULL,
    CheckTime         DATE,
    CheckReason       INT,
    DeviceSum         INT,
    CheckDeviceSum    INT,
    AbnormalDeviceSum INT
);

CREATE TABLE IF NOT EXISTS tb_check_summary
(
    deviceId                 VARCHAR(256) PRIMARY KEY NOT NULL,
    DeviceName               VARCHAR(64),
    IsChecked                BOOLEAN                  NOT NULL DEFAULT FALSE,
    UnCheckReason            INT,
    Result                   INT                               DEFAULT 0,
    ZoneResult               TINYINT,
    ZoneUncheckReason        TINYINT,
    ZoneIsChecked            BOOLEAN                           DEFAULT FALSE,
    SettingResult            TINYINT,
    SettingUncheckReason     TINYINT,
    SettingIsChecked         BOOLEAN                           DEFAULT FALSE,
    SoftPlateResult          TINYINT,
    SoftPlateUncheckReason   TINYINT,
    SoftPlateIsChecked       BOOLEAN                           DEFAULT FALSE,
    HardPlateResult          TINYINT,
    HardPlateUncheckReason   TINYINT,
    HardPlateIsChecked       BOOLEAN                           DEFAULT FALSE,
    DiscreteResult           TINYINT,
    DiscreteUncheckReason    TINYINT,
    DiscreteIsChecked        BOOLEAN                           DEFAULT FALSE,
    ClockResult              TINYINT,
    ClockUncheckReason       TINYINT,
    ClockIsChecked           BOOLEAN                           DEFAULT FALSE,
    CommStatusResult         TINYINT,
    CommStatusUncheckReason  TINYINT,
    CommStatusIsChecked      BOOLEAN                           DEFAULT FALSE,
    SecCircuitResult         TINYINT,
    SecCircuitUncheckReason  TINYINT,
    SecCircuitIsChecked      BOOLEAN                           DEFAULT FALSE,
    SoftVersionResult        TINYINT,
    SoftVersionUncheckReason TINYINT,
    SoftVersionIsChecked     BOOLEAN                           DEFAULT FALSE,
    SelfAlarmResult          TINYINT,
    SelfAlarmUncheckReason   TINYINT,
    SelfAlarmIsChecked       BOOLEAN                           DEFAULT FALSE,
    GpsAlarmResult           TINYINT,
    GpsAlarmUncheckReason    TINYINT,
    GpsAlarmIsChecked        BOOLEAN                           DEFAULT FALSE,
    WaveResult               TINYINT,
    WaveUncheckReason        TINYINT,
    WaveIsChecked            BOOLEAN                           DEFAULT FALSE,
    AnalogResult             TINYINT,
    AnalogUncheckReason      TINYINT,
    AnalogIsChecked          BOOLEAN                           DEFAULT FALSE,
    LoopResult               TINYINT,
    LoopUncheckReason        TINYINT,
    LoopIsChecked            BOOLEAN                           DEFAULT FALSE,
    ChannelResult            TINYINT,
    ChannelUncheckReason     TINYINT,
    ChannelIsChecked         BOOLEAN                           DEFAULT FALSE,
    SwitchResult             TINYINT,
    SwitchUncheckReason      TINYINT,
    SwitchIsChecked          BOOLEAN                           DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tb_check_diff_zone
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RefType     INT,
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    CONSTRAINT FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_settings
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RefVal      VARCHAR(64),
    RealVal     VARCHAR(64),
    ZoneNo      INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_hard_plate
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RefVal      INT,
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_soft_plate
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RefVal      INT,
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_discrete
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RefVal      INT,
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_clock
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RefVal      DATE,
    RealVal     DATE,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_comm_status
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointName   VARCHAR(64),
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_sec_circuit
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_soft_version
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    RefVal      VARCHAR(64),
    RealVal     VARCHAR(64),
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_self_alarm
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE IF NOT EXISTS tb_check_diff_gps_alarm
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE  IF NOT EXISTS tb_check_diff_wave
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    RealVal     VARCHAR(128),
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE  IF NOT EXISTS tb_check_diff_analog
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RealVal     FLOAT,
    LowerLimit  FLOAT,
    UpperLimit  FLOAT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);


CREATE TABLE  IF NOT EXISTS tb_check_diff_loop
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    ValType     VARCHAR(64),
    RealVal     FLOAT,
    LowerLimit  FLOAT,
    UpperLimit  FLOAT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);

CREATE TABLE  IF NOT EXISTS tb_check_diff_channel
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    DeviceId    VARCHAR(256) NOT NULL,
    PointId     VARCHAR(256),
    PointName   VARCHAR(64),
    RealVal     INT,
    CheckTime   DATE,
    IsDifferent BOOLEAN,
    FOREIGN KEY (DeviceId) REFERENCES tb_check_summary (deviceId)
);
