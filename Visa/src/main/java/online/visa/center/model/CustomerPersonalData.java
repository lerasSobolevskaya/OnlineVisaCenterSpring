package online.visa.center.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.visa.center.model.enums.Gender;

@Entity
@Table(name = "customer_personal_data")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPersonalData {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PositiveOrZero
	private Long id;

	@Column(name = "first_name")
	@NotNull(message = "First name can't be null")
	@Size(max = 50, message = "The first name must contain no more than twenty characters")
	@Pattern(regexp = "(^[A-Z][a-z]{0,20})([\\-]?)([A-Z]?[a-z]{0,20})", message = "First name should begin with a capital letter")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "Last name can't be null")
	@Size(max = 50, message = "The last name must contain no more than twenty characters")
	@Pattern(regexp = "(^[A-Z][a-z]{0,20})([\\-]?)([A-Z]?[a-z]{0,20})", message = "Last name should begin with a capital letter")
	private String lastName;

	@Column(name = "patronymic")
	@NotNull(message = "Patronymic can't be null")
	@Size(max = 50, message = "The patronymic must contain no more than twenty characters")
	@Pattern(regexp = "(^[A-Z][a-z]{0,20})([\\-]?)([A-Z]?[a-z]{0,20})", message = "Patronymic should begin with a capital letter")
	private String patronymic;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	@NotNull(message = "Gender can't be null")
	private Gender gender;

	@Column(name = "address")
	@NotNull(message = "Address can't be null")
	private String address;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_id")
	private Passport passport;
}
