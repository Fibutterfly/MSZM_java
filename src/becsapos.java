import org.apache.commons.math4.legacy.linear.Array2DRowRealMatrix;
import org.apache.commons.math4.legacy.linear.ArrayRealVector;
//import org.apache.commons.math4.legacy.linear.CholeskyDecomposition;
import org.apache.commons.math4.legacy.linear.DecompositionSolver;
//import org.apache.commons.math4.legacy.linear.EigenDecomposition;
import org.apache.commons.math4.legacy.linear.LUDecomposition;
import org.apache.commons.math4.legacy.linear.QRDecomposition;
import org.apache.commons.math4.legacy.linear.RealMatrix;
import org.apache.commons.math4.legacy.linear.RealVector;
public class becsapos {
    public static void main(String[] args) throws Exception{
        RealMatrix coef1 = new Array2DRowRealMatrix(new double[][] {{ 10e-17d, 1d }, {1d,1d}},false);
        RealMatrix coef2 = new Array2DRowRealMatrix(new double[][] {{1d,1d}, { 10e-17d, 1d } },false);
        RealVector const1 = new ArrayRealVector(
            new double[]{1,2},false
        ); 
        RealVector const2 = new ArrayRealVector(new double[]{2,1},false);
        DecompositionSolver LUD1 = new LUDecomposition(coef1).getSolver();
        //DecompositionSolver Chol1 = new CholeskyDecomposition(coef1).getSolver();
        DecompositionSolver QR1 = new QRDecomposition(coef1).getSolver();
        //DecompositionSolver EI1 = new EigenDecomposition(coef1).getSolver();
        DecompositionSolver LUD2 = new LUDecomposition(coef2).getSolver();
        //DecompositionSolver Chol2 = new CholeskyDecomposition(coef2).getSolver();
        DecompositionSolver QR2 = new QRDecomposition(coef2).getSolver();
        //DecompositionSolver EI2 = new EigenDecomposition(coef2).getSolver();
        RealVector LUD1_s = LUD1.solve(const1);
        //RealVector Chol1_s = Chol1.solve(const1);
        RealVector QR1_s = QR1.solve(const1);
        //RealVector EI1_s = EI1.solve(const1);
        RealVector LUD2_s = LUD2.solve(const2);
        //RealVector Chol2_s = Chol2.solve(const2);
        RealVector QR2_s = QR2.solve(const2);
        //RealVector EI2_s = EI2.solve(const2);
        System.out.println(LUD1_s);
        System.out.println(QR1_s);
        System.out.println(LUD2_s);
        System.out.println(QR2_s);

        RealMatrix coef3 = new Array2DRowRealMatrix(new double[][] {{ 888445, 887112 }, {887112,888445}},false);
        RealVector const3 = new ArrayRealVector(new double[]{1,0},false);
        DecompositionSolver LUD3 = new LUDecomposition(coef3).getSolver();
        DecompositionSolver QR3 = new QRDecomposition(coef3).getSolver();
        RealVector LUD3_s = LUD3.solve(const3);
        RealVector QR3_s = QR3.solve(const3);
        System.out.println("---------------------------------");
        System.out.println(LUD3_s);
        System.out.println(QR3_s);
        for (double szam : LUD3_s.toArray()) {
            String rtn = String.format("%.2e", szam);
            System.out.print(rtn + "\t");
        } 
        System.out.println("");
        for (double szam : QR3_s.toArray()) {
            String rtn = String.format("%.2e", szam);
            System.out.print(rtn + "\t");
        } 
    }

}
