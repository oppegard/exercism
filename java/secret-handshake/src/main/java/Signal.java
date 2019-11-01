enum Signal {

               WINK(0b0001),
       DOUBLE_BLINK(0b0010),
    CLOSE_YOUR_EYES(0b0100),
               JUMP(0b1000);

    private int binaryValue;

    Signal(int binaryValue) {
        this.binaryValue = binaryValue;
    }

    public boolean isContainedIn(int handshake) {
        return (handshake & binaryValue) == binaryValue;
    }
}
