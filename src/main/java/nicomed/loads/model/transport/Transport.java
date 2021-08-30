package nicomed.loads.model.transport;

import lombok.*;
import lombok.experimental.SuperBuilder;
import nicomed.loads.enums.TransportType;

@Getter
@EqualsAndHashCode
@SuperBuilder
@AllArgsConstructor
public abstract class Transport {
    private final TransportType type;
}
