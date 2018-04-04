package pipe_filter.filter;


import pipe_filter.pipe.Pipe;

import java.awt.*;

public abstract class DrawFilter extends FilterImpl<Point, Point>{

    protected Graphics g;

    public DrawFilter(Pipe<Point> input, Pipe<Point> output, Graphics graphics) {
        super(input, output);
        g = graphics;
    }

    @Override
    protected Point transformOne(Point in) {
        System.out.println("Drawing on (" + in.getX() + "," + in.getY() + ")");
        return draw(in);
    }

    protected abstract Point draw(Point originPoint);
}
