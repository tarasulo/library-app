package library.app.spring.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import library.app.spring.dto.UserDto;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, UserDto> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        return userDto.getPassword().equals(userDto.getRepeatPassword());
    }
}
