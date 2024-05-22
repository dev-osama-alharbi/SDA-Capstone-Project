package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountriesV2 {
    private String iso2;
    private String name;
    private String currency;
    private String currency_name;
    private String currency_symbol;
}
