package kea.bowlingBackend.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDTO {

        private int id;
        private String username;
        private String start;
        private String end;

        public ScheduleDTO() {
        }

        public ScheduleDTO(int id, String username, String start, String end) {
            this.id = id;
            this.username = username;
            this.start = start;
            this.end = end;
        }

        public ScheduleDTO(ScheduleDTO schedule) {
            this.id = schedule.getId();
            this.username = schedule.getUsername();
            this.start = schedule.getStart();
            this.end = schedule.getEnd();
        }

}
