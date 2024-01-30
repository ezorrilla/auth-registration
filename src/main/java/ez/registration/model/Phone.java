package ez.registration.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Phone implements Serializable {
    String number;

    String cityCode;

    String countryCode;

}
