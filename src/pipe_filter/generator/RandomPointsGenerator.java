package pipe_filter.generator;

import pipe_filter.pipe.Pipe;

import java.awt.*;
import java.util.Random;

public class RandomPointsGenerator extends Generator<Point> {
    protected int limit;

    public RandomPointsGenerator(Pipe<Point> output, int limit) {
        super(output);
        this.limit = limit;
    }

    @Override
    public void generateInto(Pipe<Point> pipe) {
        Random r = new Random();
        for (int i = 1; i <= 10; i++) {
            Point p = new Point(r.nextInt(limit)+25, r.nextInt(limit)+25);
            pipe.put(p);
        }
        pipe.closeForWriting();
    }
}
