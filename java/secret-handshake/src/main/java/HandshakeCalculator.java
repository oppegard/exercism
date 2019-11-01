import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> secretSignals = Arrays.stream(Signal.values())
            .filter(signal -> signal.isContainedIn(number))
            .collect(Collectors.toList());

        if (shouldReverse(number)) Collections.reverse(secretSignals);
        return secretSignals;
    }

    private boolean shouldReverse(int number) {
        return (number & 0b10000) == 0b10000;
    }

}
