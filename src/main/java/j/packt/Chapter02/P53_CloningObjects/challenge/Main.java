package j.packt.Chapter02.P53_CloningObjects.challenge;

import com.google.gson.Gson;
import com.rits.cloning.Cloner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.matrix.Matrices;
import org.apache.commons.lang3.SerializationUtils;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        // shallow copy via manual copy
        System.out.println("\nShallow copy via manual copy:");
        j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.manually.Point point1
                = new j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.manually.Point(5, 5);

        System.out.println("Point 1 (original), (x, y): " + point1.getX() + ", " + point1.getY());
        j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.manually.Point clone1
                = point1.clonePoint();
        point1.setX(10);
        point1.setY(10);
        System.out.println("Point 1 (modified), (x, y): " + point1.getX() + ", " + point1.getY());
        System.out.println("Clone 1, (x, y): " + clone1.getX() + ", " + clone1.getY());

        // shallow copy via the clone() method
        System.out.println("\nShallow copy via the clone() method:");
        j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.clone.Point point2
                = new j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.clone.Point(5, 5);

        System.out.println("Point 2 (original), (x, y): " + point2.getX() + ", " + point2.getY());
        j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.clone.Point clone2
                = point2.clone();
        point2.setX(10);
        point2.setY(10);
        System.out.println("Point 2 (modified), (x, y): " + point2.getX() + ", " + point2.getY());
        System.out.println("Clone 2, (x, y): " + clone2.getX() + ", " + clone2.getY());

        // shallow copy via constructor
        System.out.println("\nShallow copy via constructor:");
        j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.constructor.Point point3
                = new j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.constructor.Point(5, 5);

        System.out.println("Point 3 (original), (x, y): " + point3.getX() + ", " + point3.getY());
        j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.constructor.Point clone3
                = new j.packt.Chapter02.P53_CloningObjects.challenge.shallow.copy.constructor.Point(point3);
        point3.setX(10);
        point3.setY(10);
        System.out.println("Point 3 (modified), (x, y): " + point3.getX() + ", " + point3.getY());
        System.out.println("Clone 3, (x, y): " + clone3.getX() + ", " + clone3.getY());

        // deep copy via the Cloning library
        System.out.println("\nDeep copy Cloning library:");
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.cloning.Radius radius4
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.cloning.Radius();
        radius4.setStart(0);
        radius4.setEnd(10);
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.cloning.Point point4
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.cloning.Point(5, 5, radius4);

        System.out.println("Point 4 (original), (x, y, Radius start, Radius end): "
                + point4.getX() + ", " + point4.getY()
                + ", " + point4.getRadius().getStart() + ", " + point4.getRadius().getEnd());

        Cloner cloner = new Cloner();
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.cloning.Point clone4
                = cloner.deepClone(point4);
        point4.setX(10);
        point4.setY(10);
        point4.getRadius().setStart(5);
        point4.getRadius().setEnd(100);
        System.out.println("Point 4 (modified), (x, y, Radius start, Radius end): "
                + point4.getX() + ", " + point4.getY()
                + ", " + point4.getRadius().getStart() + ", " + point4.getRadius().getEnd());
        System.out.println("Clone 4, (x, y, Radius start, Radius end): "
                + clone4.getX() + ", " + clone4.getY()
                + ", " + clone4.getRadius().getStart() + ", " + clone4.getRadius().getEnd());

        // deep copy via SerializationUtils
        System.out.println("\nDeep copy via SerializationUtils:");
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Radius radius5
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Radius();
        radius5.setStart(0);
        radius5.setEnd(10);
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point point5
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point(5, 5, radius5);

        System.out.println("Point 5 (original), (x, y, Radius start, Radius end): "
                + point5.getX() + ", " + point5.getY()
                + ", " + point5.getRadius().getStart() + ", " + point5.getRadius().getEnd());

        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point clone5
                = SerializationUtils.clone(point5);

        point5.setX(10);
        point5.setY(10);
        point5.getRadius().setStart(5);
        point5.getRadius().setEnd(100);
        System.out.println("Point 5 (modified), (x, y, Radius start, Radius end): "
                + point5.getX() + ", " + point5.getY()
                + ", " + point5.getRadius().getStart() + ", " + point5.getRadius().getEnd());
        System.out.println("Clone 5, (x, y, Radius start, Radius end): "
                + clone5.getX() + ", " + clone5.getY()
                + ", " + clone5.getRadius().getStart() + ", " + clone5.getRadius().getEnd());

        // deep copy via serialization helper method
        System.out.println("\nDeep copy via serialization helper method:");
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Radius radius6
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Radius();
        radius6.setStart(0);
        radius6.setEnd(10);
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point point6
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point(5, 5, radius6);

        System.out.println("Point 6 (original), (x, y, Radius start, Radius end): "
                + point6.getX() + ", " + point6.getY()
                + ", " + point6.getRadius().getStart() + ", " + point6.getRadius().getEnd());

        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point clone6
                = cloneThroughSerialization(point6);

        point6.setX(10);
        point6.setY(10);
        point6.getRadius().setStart(5);
        point6.getRadius().setEnd(100);
        System.out.println("Point 6 (modified), (x, y, Radius start, Radius end): "
                + point6.getX() + ", " + point6.getY()
                + ", " + point6.getRadius().getStart() + ", " + point6.getRadius().getEnd());
        System.out.println("Clone 6, (x, y, Radius start, Radius end): "
                + clone6.getX() + ", " + clone6.getY()
                + ", " + clone6.getRadius().getStart() + ", " + clone6.getRadius().getEnd());

        // deep copy via JSON (Gson library (use Jackson if you are more familiar with that one))
        System.out.println("\nDeep copy via JSON (Gson):");
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Radius radius7
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Radius();
        radius7.setStart(0);
        radius7.setEnd(10);
        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point point7
                = new j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point(5, 5, radius7);

        System.out.println("Point 7 (original), (x, y, Radius start, Radius end): "
                + point7.getX() + ", " + point7.getY()
                + ", " + point7.getRadius().getStart() + ", " + point7.getRadius().getEnd());

        j.packt.Chapter02.P53_CloningObjects.challenge.deep.copy.serialization.Point clone7
                = cloneThroughJson(point7);

        point7.setX(10);
        point7.setY(10);
        point7.getRadius().setStart(5);
        point7.getRadius().setEnd(100);
        System.out.println("Point 7 (modified), (x, y, Radius start, Radius end): "
                + point7.getX() + ", " + point7.getY()
                + ", " + point7.getRadius().getStart() + ", " + point7.getRadius().getEnd());
        System.out.println("Clone 7, (x, y, Radius start, Radius end): "
                + clone7.getX() + ", " + clone7.getY()
                + ", " + clone7.getRadius().getStart() + ", " + clone7.getRadius().getEnd());

        int[][] source = {{3, 1, 5}, {3, 6, 7}};

        // shallow copy of matrix (1)
        System.out.println("\nShallow copy of matrix via manual copy (1):");
        int[][] target1 = Matrices.cloneArrayOfInt1(source);
        target1[0][0] = 0;
        System.out.println("Original array:");
        printMatrix(source);
        System.out.println("Cloned and modified array:");
        printMatrix(target1);

        // shallow copy of matrix (2)
        System.out.println("\nShallow copy of matrix via manual copy (2):");
        int[][] target2 = Matrices.cloneArrayOfInt2(source);
        target2[0][0] = 0;
        System.out.println("Original array:");
        printMatrix(source);
        System.out.println("Cloned and modified array:");
        printMatrix(target2);

        // shallow copy of matrix (3)
        System.out.println("\nShallow copy of matrix via manual copy (3):");
        int[][] target3 = Matrices.cloneArrayOfInt3(source);
        target3[0][0] = 0;
        System.out.println("Original array:");
        printMatrix(source);
        System.out.println("Cloned and modified array:");
        printMatrix(target3);

        // shallow copy of matrix (4)
        System.out.println("\nShallow copy of matrix via manual copy (4):");
        int[][] target4 = Matrices.cloneArrayOfInt4(source);
        target4[0][0] = 0;
        System.out.println("Original array:");
        printMatrix(source);
        System.out.println("Cloned and modified array:");
        printMatrix(target4);
    }

    @SuppressWarnings("unchecked")
    private static <T> T cloneThroughJson(T t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return (T) gson.fromJson(json, t.getClass());
    }

    private static <T> T cloneThroughSerialization(T t) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(t);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            // log exception
            return t;
        }
    }

    // helper method to display a matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
