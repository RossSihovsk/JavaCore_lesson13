import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Faction {

    List <Deputy>   deputies  = new ArrayList<>();
    String name;

    public Faction(String name) {
        this.name = name;
    }

    void    addDeputy(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть імя депутата");
            String name = scanner.nextLine();

            System.out.println("Введіть прізвище депутата");
            String surname = scanner.nextLine();


            System.out.println("Введіть бере від взятки чи ні(true або false)");
            boolean bribler =  scanner.nextBoolean();


            System.out.println("Введіть ріст депутата");
            float height = scanner.nextFloat();


            System.out.println("Введіть вагу депутата");
            float weight = scanner.nextFloat();

            deputies.add(new Deputy(weight,height,name,surname,bribler));
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип введених вами данних!");
        }


    }


    void removeDeputy(){
        if (deputies.size()<1){
            System.out.println("У вашій фракції ще немає депутатів! Спочатку добавте їх!");
        }
        else{
            try{
                Iterator <Deputy> iterator = deputies.iterator();
                Scanner scanner = new Scanner(System.in);
                int count =0;
                while (iterator.hasNext()){
                    System.out.println("Порядковий номер: "+count + "Депутат: "+iterator.next().toString());
                    count++;
                }
                System.out.println("Виберіть за порядковим номером якого депутата бажаєте виключити: ");
                int x = scanner.nextInt();
                deputies.remove(x);
                System.out.println("Видалення прошйло успішно.");
            }
            catch (Exception exception){
                System.out.println("Ви щось не так ввели. Перевірте тип введених вами данних!");
            }
        }
    }


    void seeAllBriblers(){
        System.out.println("Всі хабарники в партії "+ this.name);
        for (Deputy d:deputies) {
            if (d.bribler==true){
                System.out.println(d.toString());
            }
        }
    }

    void seeAllDeputies(){
        for (Deputy d: deputies
             ) {
            System.out.println(d.toString());
        }
    }


    void theBiggestSizeOfBribe(){

        double sifeOfBribe = 0;
        int index;
        int temp;
        Iterator <Deputy> iterator = deputies.iterator();
        for (Deputy d:deputies
             ) {
            if (d.sizeOfbribe>sifeOfBribe ){
                sifeOfBribe=d.sizeOfbribe;
            }
        }
        if (sifeOfBribe!=0){
            System.out.println("Найбільші хабарники партії "+ this.name);
            for (Deputy d: deputies
                 ) {
                if (d.sizeOfbribe ==sifeOfBribe){
                    System.out.println(d.toString());
                }
            }
        }
        else{
            System.out.println("У фракції "+this.name + " немає хабарників");
        }
    }


    void deleteAllDeputiesFromFaction(){
        if (deputies.size()<1){
            System.out.println("Ви не можете очистити фракцію оскільки вона і так пуста :( ");
        }
        else {
            deputies.clear();
            System.out.println("Фракцію успішно  очищено.");
        }


    }

    void brible(){
        Iterator<Deputy> iterator = deputies.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Депутат  "+iterator.next().toString());
        }
        System.out.println("Введіть індекс депутата якому хочете дати хабаря  ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Deputy d:deputies
            ) {
                if (tempInd==index){
                    d.takeBrible();
                    break;
                }
                else index++;
            }
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }

    @Override
    public String toString() {
        return "Faction{" +
                "name='" + name + '\'' +
                '}';
    }
}
