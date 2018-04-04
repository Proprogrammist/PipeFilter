package pipe_filter.filter;


import pipe_filter.pipe.Pipe;

import java.awt.*;

public class LineFilter extends DrawFilter{
    protected Point offset;

    public LineFilter(Pipe<Point> input, Pipe<Point> output, Graphics graphics, Point offset) {
        super(input, output, graphics);
        this.offset = offset;
    }

    @Override
    protected Point draw(Point originPoint) {
        Point endPoint = new Point((int)(originPoint.getX() + offset.getX()), (int)(originPoint.getY() + offset.getY()));
        g.drawLine((int)originPoint.getX(), (int)originPoint.getY(), (int)endPoint.getX(),(int)endPoint.getY());
        return endPoint;
    }
}
