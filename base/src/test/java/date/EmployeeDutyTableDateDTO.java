package date;

import lombok.Data;

/**
 * @ClassName: EmployeeDutyTableDateDTO
 * @Description:
 * @Author: xuxinhui@zhuanzhaun.com
 * @Date: 2022/8/16 15:09
 **/
@Data
public class EmployeeDutyTableDateDTO {
    private String dateInfo;
    private String dateInfoDesc;
    private Integer dutyYear;
    private Integer dutyWeek;


    public EmployeeDutyTableDateDTO() {
    }

    public EmployeeDutyTableDateDTO(String dateInfo, String dateInfoDesc, Integer dutyYear, Integer week) {
        this.dateInfo = dateInfo;
        this.dateInfoDesc = dateInfoDesc;
        this.dutyYear = dutyYear;
        this.dutyWeek = week;
    }
}
