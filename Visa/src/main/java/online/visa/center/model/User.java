package online.visa.center.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.visa.center.model.enums.Role;

@Entity
@Table(name = "user")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "user_id")
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
	@Column(name = "role")
	@NotNull(message = "Role can't be null")
	private Role role = Role.USER;

	@Column(name = "username")
	@NotNull(message = "Username can't be null")
	private String username;

	@Column(name = "password")
	@NotNull(message = "Password can't be null")
	private String password;

	@Column(name = "email")
	@Email
	@NotNull(message = "Email can't be null")
	private String email;

}
