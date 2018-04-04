package pipe_filter.sink;

import pipe_filter.pipe.Pipe;

public abstract class SimpleSink<T> extends Sink<T> {
    public SimpleSink(Pipe<T> input) {
        super(input);
    }

    @Override
    public void takeFrom(Pipe<T> pipe) {
        try {
            T in;
            while ((in = pipe.nextOrNullIfEmptied()) != null) {
                handle(in);
            }
        } catch (InterruptedException e) {
            System.err.println("interrupted");
            e.printStackTrace();
        }
    }

    protected abstract void handle(T in);
}
