package pl.mg.tr.user.service;

import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {

    public UserDto getUserDto() {
        return userDto;
    }

    private UserDto userDto;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserCreatedEvent(Object source) {
        super(source);
    }

    public UserCreatedEvent(UserDto userDto) {
        super(userDto);
        this.userDto = userDto;
    }
}
