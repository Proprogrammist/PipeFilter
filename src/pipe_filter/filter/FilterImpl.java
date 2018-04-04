package pipe_filter.filter;

import pipe_filter.pipe.Pipe;

public abstract class FilterImpl<I, O> extends Filter<I, O> {
    public FilterImpl(Pipe<I> input, Pipe<O> output) {
        super(input, output);
    }

    @Override
    protected void transformBetween(Pipe<I> input, Pipe<O> output) {
        try {
            I in;
            while ((in = input.nextOrNullIfEmptied()) != null) {
                O out = transformOne(in);
                output.put(out);
            }
        } catch (InterruptedException e) {
            System.err.println("interrupted");
            e.printStackTrace();
            return;
        }
        output.closeForWriting();
    }

    protected abstract O transformOne(I in);
}
