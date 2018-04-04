package pipe_filter.sink;


import pipe_filter.pipe.Pipe;

import java.awt.*;

public class DrawSink extends Sink<Point> {
    public DrawSink(Pipe<Point> input) {
        super(input);
    }

    @Override
    public void takeFrom(Pipe<Point> pipe) {
        try {
            Point in;
            while ((in = pipe.nextOrNullIfEmptied()) != null) {
                System.out.println("Finished drawing at (" + in.getX() + "," + in.getY() + ")");
            }
        } catch (InterruptedException e) {
            System.err.println("interrupted");
            e.printStackTrace();
        } finally {
            System.out.close();
        }
    }
}
