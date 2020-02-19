package online.visa.center.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Passport {

	@Id
	@Column(name = "passport_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PositiveOrZero
	private Long id;

	@Column(name = "passport_number")
	@NotNull(message = "Passport number can't be null")
	private String passportNum;

	@Column(name = "issued_by")
	@NotNull(message = "Issued by number can't be null")
	private String issuedBy;

	@Column(name = "issue_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of issue number can't be null")
	private LocalDate dateOfIssue;

	@Column(name = "expiry_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of expiry number can't be null")
	private LocalDate dateOfExpiry;
}
