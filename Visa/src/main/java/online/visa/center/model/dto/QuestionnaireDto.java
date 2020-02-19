package online.visa.center.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.visa.center.model.enums.QuestionnaireStatus;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionnaireDto {

	@PositiveOrZero
	private Long id;

	@NotNull(message = "Status can't be null")
	private QuestionnaireStatus status = QuestionnaireStatus.UNDER_CONSIDERATION;

	private SchengenVisaDto visa;

	private CustomerDataDto customerData;

	private UserDto user;
}
