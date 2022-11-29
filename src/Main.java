import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mat;
        ArrayList<Cliente> clients = new ArrayList<>();
        ArrayList<Cliente> devol = new ArrayList<>();
        Cliente cliente= new Cliente(2020, "Luisa", "CG2345", 302.9 );
        Cliente cliente2= new Cliente(3030, "Juan Pepe", "CG9384", 292.9 );
        clients.add(cliente); clients.add(cliente2);
        ObjectIO objectIO = new ObjectIO("./src/clientes.obj");
        //File obj = new File("./srs/SegurosDirecto.dat");

        objectIO.writeObject(clients);

        devol = objectIO.readObject();
        System.out.println("AAAA CURBA");
        for(int i =0; i<devol.size(); i++){
            System.out.println(devol.get(i).toString());
        }
        RandomAccessIO randomAccessIO = new RandomAccessIO("./src/SegurosDirecto.dat");
        randomAccessIO.initWriter();
        for(int i =0; i<devol.size(); i++){
            randomAccessIO.writeFile(RandomAccessIO.BYTES.INT,devol.get(i).getPoliza());
            randomAccessIO.writeFile(RandomAccessIO.BYTES.STRINGBUFFER,devol.get(i).getCliente());
            randomAccessIO.writeFile(RandomAccessIO.BYTES.STRINGBUFFER,devol.get(i).getMatric());
            randomAccessIO.writeFile(RandomAccessIO.BYTES.DOUBLE,devol.get(i).getCuota());
        }
        randomAccessIO.closeWriter();

        RandomAccessIO.BYTES[] bytes = new RandomAccessIO.BYTES[]{
                RandomAccessIO.BYTES.INT,
                RandomAccessIO.BYTES.STRINGBUFFER,
                RandomAccessIO.BYTES.STRINGBUFFER,
                RandomAccessIO.BYTES.DOUBLE
        };
        System.out.println("Matri-culo");
        mat = sc.nextLine();
        int[] idPos = randomAccessIO.searchPositionById(String.valueOf(mat),bytes);
        ArrayList<String> listByPos = randomAccessIO.readByPosition(idPos[0],bytes);
        System.out.println("POSICION 3 = "+ listByPos.get(3));
        Double newnum = Double.parseDouble( listByPos.get(3));
        Double res = newnum-(newnum*0.15);
        for (String text: listByPos){
            System.out.println("ABAJO \\//  "+ res);
            System.out.println(text);
        }
        idPos = randomAccessIO.searchPositionById(String.valueOf(listByPos.get(3)),bytes);
       randomAccessIO.initWriter();
       randomAccessIO.writeFileByPos(RandomAccessIO.BYTES.DOUBLE,res,idPos[1]);
       randomAccessIO.closeWriter();
        //idPos = randomAccessIO.searchPositionById(String.valueOf(mat),bytes);
        listByPos = randomAccessIO.readByPosition(idPos[0],bytes);
        for (String text: listByPos){
            System.out.println("NUEVO \\//  ");
            System.out.println(text);
        }

    }
}