package fans.connectable.admin.event.domain;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Event {
    private final Long id;
    private final String eventName;
    private final String description;
    private final String contractAddress;
    private final String contractName;

    @Builder
    public Event(Long id, String eventName, String description, String contractAddress, String contractName) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.contractAddress = contractAddress;
        this.contractName = contractName;
    }
}
