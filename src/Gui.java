import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by halil on 27.11.2016.
 */
public class Gui extends JPanel implements ActionListener {

    private JFrame frame;
    private JInternalFrame jInternalFrame;
    private JTabbedPane tabbedPane;
    private JPanel gui1;
    private JMenuBar menuBar;
    private JMenu createShapes, display, help;
    private JMenuItem randomShapes, rectangle, circle, square, exit,
            displayAll, disRect, disCircle, disSquare,
            author, version;
    //Table to show shapes that created.
    private DefaultTableModel tableModel;
    private JTable tabelOne;

    private JLabel label;

    //Arraylists to hold the objects in it.
    private ArrayList<Object> allShapes = new ArrayList<>();
    private ArrayList<Object> allSquares = new ArrayList<>();
    private ArrayList<Object> allCircles = new ArrayList<>();
    private ArrayList<Object> allRectangles = new ArrayList<>();
    static ArrayList<Object> temp = new ArrayList<>();
    //Paramaters to print total area of all objects.
    private static double areaOfAllShapes = 0;
    private static double areaOfAllCircle = 0;
    private static double areaOfAllSquares = 0;
    private static double areaOfAllRectangles = 0;

    //Creates frame to add panel.
    private void createFrame() {
        frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setFocusable(false);
        setVisible(true);
        setSize(1000, 600);
    }

    //Creates menus and add them to menubar.
    private void createMenus() {

        menuBar = new JMenuBar();
        createShapes = new JMenu("CreateShapes");
        menuBar.add(createShapes);
        display = new JMenu("Display");
        menuBar.add(display);
        help = new JMenu("Help");
        menuBar.add(help);

        randomShapes = new JMenuItem("Random Shapes");
        createShapes.add(randomShapes);
        rectangle = new JMenuItem("Rectangle");
        createShapes.add(rectangle);
        circle = new JMenuItem("Circle");
        createShapes.add(circle);
        square = new JMenuItem("Square");
        createShapes.add(square);
        exit = new JMenuItem("Exit");
        createShapes.add(exit);

        displayAll = new JMenuItem("Display All");
        display.add(displayAll);
        disRect = new JMenuItem("Rectangle");
        display.add(disRect);
        disCircle = new JMenuItem("Circle");
        display.add(disCircle);
        disSquare = new JMenuItem("Square");
        display.add(disSquare);

        author = new JMenuItem("Author");
        help.add(author);
        version = new JMenuItem("Version");
        help.add(version);

    }

    //Creates to tabs to display shapes and tables.
    private void createTabs() {
        tabbedPane = new JTabbedPane();
        frame.getContentPane().add(tabbedPane);

        jInternalFrame = new JInternalFrame();
        jInternalFrame.setEnabled(true);
        jInternalFrame.setVisible(true);
        jInternalFrame.setSize(1000,600);

        jInternalFrame.add(this);
        jInternalFrame.setJMenuBar(menuBar);

        //Shapes tab to show informations of shapes.
        tabbedPane.addTab("Shapes", jInternalFrame);
        //Images tab shapes to show images.
        tabbedPane.addTab("Images", this);

        label = new JLabel();
        jInternalFrame.add(label, BorderLayout.PAGE_END);
        label.setText("Information");
    }

    //Creates tabs, adds column names to table.
    private void createTable() {
        String [] columnNames = {"ID", "Type", "Area", "Full Shape", "Distance", "Properties"};

        tableModel = new DefaultTableModel(null ,columnNames);
        tabelOne = new JTable(tableModel);
        tabelOne.getColumn("ID").setMaxWidth(75);
        tabelOne.getColumn("Type").setMaxWidth(75);
        tabelOne.getColumn("Full Shape").setMaxWidth(75);
    }

    //Takes a arraylist and update the table respect to this arraylist.
    private void updateTable(ArrayList<Object> arrayList){
        ArrayList<Shapes> temp = new ArrayList<>();

        if (arrayList == allShapes) {
            tableModel.setRowCount(0);
        }


        for (Object obj: arrayList) {
            temp.add((Shapes) obj);
        }
        for (Shapes obj: temp) {
            tableModel.addRow(obj.toArray());
        }
    }

    //Constructor to create interface.
    private Gui() {

        createFrame();
        frame.add(this);

        createMenus();
        createTabs();

        createTable();

        jInternalFrame.add(new JScrollPane(tabelOne));

        //Added listeners to all components.
        listenerForItems();
    }

    //Takes type and number of objects and creates objects depends on these objects.
     void createShapes(Object typeOfShapes, int numberOfShapes) {
        temp = allShapes;

        if (typeOfShapes.equals(randomShapes)) {
            checkArrays(allShapes, numberOfShapes);

            JOptionPane.showMessageDialog(null, numberOfShapes + " " + "random shape have been created.");
            updateTable(allShapes);

        } else if (typeOfShapes.equals(circle)) {
            checkArrays(allCircles, numberOfShapes);

            JOptionPane.showMessageDialog(null, numberOfShapes + " " + "circle have been created.");
            updateTable(allCircles);

        } else if (typeOfShapes.equals(rectangle)) {
            checkArrays(allRectangles, numberOfShapes);

            JOptionPane.showMessageDialog(null, numberOfShapes + " " + "rectangle have been created.");
            updateTable(allRectangles);

        } else if (typeOfShapes.equals(square)) {
            checkArrays(allSquares, numberOfShapes);

            JOptionPane.showMessageDialog(null, numberOfShapes + " " + "squares have been created.");
            updateTable(allSquares);
        }
    }

    //Checks array for ask the other objects in lists.
    void checkArrays(ArrayList<Object> list, int numberOfShapes) {

        /*
        * This if part checks lists if there are objects in it.*/
        if (!allShapes.isEmpty()) {
            //int answer;
            int answer = JOptionPane.showConfirmDialog(null, "There are some shapes. Would you like to delete them?",
                    "Shapes", JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION) {
                allShapes.clear();
                allCircles.clear();
                allRectangles.clear();
                allSquares.clear();
                tableModel.setRowCount(0);

                JOptionPane.showMessageDialog(null, "The shapes have been deleted.");
            } else {}
        }

        //This for loop create shapes respect to user inputs.
        for (int i = 0; i < numberOfShapes; i++) {
            int j;
            IShape[] object = {new Square(), new Circle(), new Rectangle()};
            if (list == allCircles){
                j = 1;
            } else if (list == allSquares){
                j = 0;
            } else if(list == allRectangles) {
                j = 2;
            } else {
                j = (int) (Math.random() * 3 + 1) - 1;
            }

            //This part checks the objects and put these to a array depends to their types.
            IShape objectTemp = object[j];
            if (objectTemp.getObjectName().equals("circle")) {
                allCircles.add(object[j]);
                areaOfAllCircle += object[j].area();
            } else if (objectTemp.getObjectName().equals("square")) {
                allSquares.add(object[j]);
                areaOfAllSquares += object[j].area();
            } else if (objectTemp.getObjectName().equals("rectangle")) {
                allRectangles.add(object[j]);
                areaOfAllRectangles += object[j].area();
            }
            allShapes.add(object[j]);//Adds the objects allShapes to arraylist in all situations.
            areaOfAllShapes += object[j].area();
        }
    }

    //Prints informations about created shapes and area of them.
    void printShapes(Object typeOfShapes) {

        if (typeOfShapes.equals(allShapes)) {
            label.setText("There are " + allShapes.size() + " shapes have been listed and " +
                    "the total area of all shapes is: " + String.format("%.3f",areaOfAllShapes));

        } else if (typeOfShapes.equals(allCircles)) {
            label.setText("There are " + allCircles.size() + " circles have been listed and " +
                    "the total area of all shapes is: " + String.format("%.3f",areaOfAllCircle));

        } else if (typeOfShapes.equals(allRectangles)) {
            label.setText("There are " + allRectangles.size() + " rectangles have been listed and " +
                    "the total area of all shapes is: " + String.format("%.3f",areaOfAllRectangles));

        } else if (typeOfShapes.equals(allSquares)) {
            label.setText("There are " + allSquares.size() + " rectangles have been listed and " +
                    "the total area of all shapes is: " + String.format("%.3f",areaOfAllSquares));

        }
    }

    //Adds listeners to items.
    void listenerForItems(){
        randomShapes.addActionListener(this);
        rectangle.addActionListener(this);
        circle.addActionListener(this);
        square.addActionListener(this);
        exit.addActionListener(this);
        displayAll.addActionListener(this);
        disRect.addActionListener(this);
        disCircle.addActionListener(this);
        disSquare.addActionListener(this);
        author.addActionListener(this);
        version.addActionListener(this);

    }

    //To draw and fill the shapes.
    public void paint(Graphics g) {
        super.paint(g);

        //Generate different color for shapes.
        Random random = new Random();
        float color1;
        float color2;
        float color3;
        Color randomColor;

        //Checks all objects and draw them.
        for (Object obj:temp) {

            if (obj.getClass().getName().equals("Circle")) {

                g.fillOval((int) ((Circle) obj).getX(),
                        (int) ((Circle) obj).getY(),
                        (int) ((Circle) obj).getRadius(),
                        (int) ((Circle) obj).getRadius());

                color1 = random.nextFloat();
                color2 = random.nextFloat();
                color3 = random.nextFloat();
                randomColor = new Color(color1,color2, color3);
                g.setColor(randomColor);
            } else if (obj.getClass().getName().equals("Rectangle")) {

                g.fillRect((int) ((Rectangle) obj).getX(),
                        (int) ((Rectangle) obj).getY(),
                        (int) ((Rectangle) obj).getWidth(),
                        (int) ((Rectangle) obj).getHeight());

                color1 = random.nextFloat();
                color2 = random.nextFloat();
                color3 = random.nextFloat();
                randomColor = new Color(color1,color2, color3);
                g.setColor(randomColor);
            }  else if (obj.getClass().getName().equals("Square")) {

                g.fillRect((int) ((Square) obj).getX(),
                        (int) ((Square) obj).getY(),
                        (int) ((Square) obj).getEdge(),
                        (int) ((Square) obj).getEdge());

                color1 = random.nextFloat();
                color2 = random.nextFloat();
                color3 = random.nextFloat();
                randomColor = new Color(color1,color2, color3);
                g.setColor(randomColor);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //Paramater to createShapes method.
        Object respond = null;

        //Exit if user clicked to exit button.
        if (actionEvent.getSource().equals(exit)) {
            System.exit(0);
        }

        //If stataments to create objects depends on user.
        if (actionEvent.getSource().equals(randomShapes) || actionEvent.getSource().equals(rectangle) ||
                actionEvent.getSource().equals(square) || actionEvent.getSource().equals(circle)) {

            respond = actionEvent.getSource();

            String numberOfShapes = JOptionPane.showInputDialog(null, "Input the shape numbers", "Input",
                    JOptionPane.QUESTION_MESSAGE);

            if (numberOfShapes != null) {
                createShapes(respond, Integer.parseInt(numberOfShapes));
            }

        }
        else if (actionEvent.getSource().equals(displayAll)) {
            temp = allShapes;
            repaint();
            tableModel.setRowCount(0);
            updateTable(allShapes);
            printShapes(temp);
        }
        else if (actionEvent.getSource().equals(disRect)) {
            temp =  allRectangles;
            repaint();
            tableModel.setRowCount(0);
            updateTable(allRectangles);
            printShapes(temp);
        }
        else if (actionEvent.getSource().equals(disSquare)) {
            temp = allSquares;
            repaint();
            tableModel.setRowCount(0);
            updateTable(allSquares);
            printShapes(temp);
        }
        else if (actionEvent.getSource().equals(disCircle)) {
            temp = allCircles;
            repaint();
            tableModel.setRowCount(0);
            updateTable(allCircles);
            printShapes(temp);

        } else if (actionEvent.getSource().equals(author)) {
            JOptionPane.showMessageDialog(null, "Halil Eren Ertan");

        } else if (actionEvent.getSource().equals(version)) {
            JOptionPane.showMessageDialog(null, "Project-02");
        }
    }

    public static void main(String[] args) {
        Gui gui = new Gui();

    }
}
