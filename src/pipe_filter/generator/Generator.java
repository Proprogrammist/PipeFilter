package pipe_filter.generator;

import pipe_filter.ThreadedRunner;
import pipe_filter.pipe.Pipe;

public abstract class Generator<T> extends ThreadedRunner {
    protected Pipe<T> output;

    public Generator(Pipe<T> output) {
        this.output = output;
    }

    @Override
    public void run() {
        generateInto(output);
    }

    public abstract void generateInto(Pipe<T> pipe);
}
