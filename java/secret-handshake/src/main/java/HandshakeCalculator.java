import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> signals = Arrays.stream(Signal.values())
            .filter(signal -> signal.isMemberOf(number))
            .collect(Collectors.toList());

        if (signals.remove(Signal.REVERSE)) Collections.reverse(signals);

        return signals;
    }

}
