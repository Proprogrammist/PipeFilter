import javax.swing.*;

import pipe_filter.ThreadedRunner;
import pipe_filter.filter.Filter;
import pipe_filter.filter.LineFilter;
import pipe_filter.generator.Generator;
import pipe_filter.generator.RandomPointsGenerator;
import pipe_filter.pipe.Pipe;
import pipe_filter.pipe.PipeImpl;
import pipe_filter.sink.DrawSink;
import pipe_filter.sink.SimpleSink;
import pipe_filter.sink.Sink;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {

    private static JFrame frame;
    private JPanel panel1;
    private JButton button1;

    public static void main(String[] args) {

        frame = new JFrame("Pipe-Filter Drawing :)");

        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainForm() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw();
            }
        });
    }

    private void draw() {

        Graphics g = panel1.getGraphics();

        g.clearRect(0,0, 500, 500);

        final Pipe<Point> genToFilter = new PipeImpl<Point>();
        final Pipe<Point> int1 = new PipeImpl<Point>();
        final Pipe<Point> int2 = new PipeImpl<Point>();
        final Pipe<Point> int3 = new PipeImpl<Point>();
        final Pipe<Point> filterToOut = new PipeImpl<Point>();

        final Generator<Point> generator = new RandomPointsGenerator( genToFilter, 400);
        final Filter<Point, Point> filter1 = new LineFilter(genToFilter, int1, g, new Point(50, 0));
        final Filter<Point, Point> filter2= new LineFilter(int1, int2, g, new Point(0, 50));
        final Filter<Point, Point> filter3 = new LineFilter(int2, int3, g, new Point(-50, 0));
        final Filter<Point, Point> filter4 = new LineFilter(int3, filterToOut, g, new Point(0, -50));
        final Sink<Point> sink = new DrawSink(filterToOut);

        generator.start();
        filter1.start();
        filter2.start();
        filter3.start();
        filter4.start();
        sink.start();
    }
}
