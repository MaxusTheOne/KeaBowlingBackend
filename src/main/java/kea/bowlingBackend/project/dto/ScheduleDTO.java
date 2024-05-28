package kea.bowlingBackend.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDTO {

        private String id;
        private String start;
        private String end;

        public ScheduleDTO() {
        }

        public ScheduleDTO(String id, String start, String end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

}
