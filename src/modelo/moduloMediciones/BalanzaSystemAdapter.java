package modelo.moduloMediciones;
import modelo.Socio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BalanzaSystemAdapter implements AdapterMedida {

    private ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10));
    private Random random = new Random();

    @Override
    public Medida tomarMedidas(Socio soc) {
        double pesoActual = soc.getPeso();  // Assuming Socio has a getPeso method
        double alturaAct = soc.getAltura();
        double porcentajeGrasaAct =soc.getPorcentajeGrasa();
        double porcentMusc = soc.getPorcentajeMusculo(); 
        // Generate random values based on the socio's current weight
        double peso = pesoActual + getRandomValue();
        double altura = alturaAct + getRandomValue();
        double porcentajeGrasa = porcentajeGrasaAct + getRandomValue();
        double porcentajeMusculo =porcentMusc + getRandomValue();

        Medida med = new Medida(peso, altura, porcentajeGrasa, porcentajeMusculo, null);

        return med;
    }

    // Helper method to get a random value from the 'nums' ArrayList
    private int getRandomValue() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}
