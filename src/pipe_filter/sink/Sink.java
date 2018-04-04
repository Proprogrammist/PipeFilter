package pipe_filter.sink;

import pipe_filter.ThreadedRunner;
import pipe_filter.pipe.Pipe;

public abstract class Sink<T> extends ThreadedRunner {
    protected Pipe<T> input;

    public Sink(Pipe<T> input) {
        this.input = input;
    }

    @Override
    public void run() {
        takeFrom(input);
    }

    public abstract void takeFrom(Pipe<T> pipe);
}
