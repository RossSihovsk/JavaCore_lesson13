import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VerhovnaRada {

    List<Faction> factions  = new ArrayList<>();

    void addFaction(){
        System.out.println("Введіть імя фракції ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.length()>0){
            factions.add(new Faction(name));
            System.out.println("Фракція" + name + "успішно створена");
        }
        else {
            System.out.println("Ви нічого не ввели! ");
        }
    }

    void removeFaction(){
        if (factions.size()<1){
            System.out.println("У раді ще не має фракцій. Спочатку добавте їх.");
        }
        else{
            try{
                Iterator<Faction> iterator = factions.iterator();
                Scanner scanner = new Scanner(System.in);
                int count =0;
                while (iterator.hasNext()){
                    System.out.println("Порядковий номер: "+count + "Фракція: "+iterator.next().toString());
                    count++;
                }
                System.out.println("Виберіть за порядковим номером яку фракцію бажаєте видалити ");
                int x = scanner.nextInt();
                factions.remove(x);
                System.out.println("Видалення прошйло успішно.");
            }
            catch (Exception exception){
                System.out.println("Ви щось не так ввели. Перевірте тип введених вами данних!");
            }
        }
    }

    void seeAllFactions(){
        System.out.println("Всі фракції що є у верховінй раді:");
        for (Faction f:factions
             ) {
            System.out.println(f.toString());
        }
    }

    void addDeputyInSomeFaction(){
        Iterator<Faction> iterator = factions.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Фракція "+iterator.next().toString());
            index++;
        }
        System.out.println("Введіть індекс партії в яку хочете добавити депутата: ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Faction f:factions
            ) {
                if (tempInd==index){
                    f.addDeputy();
                    break;
                }
                else index++;
            }
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }

    void removeDeputyFromSomeFaction(){
        Iterator<Faction> iterator = factions.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Фракція "+iterator.next().toString());
            index++;
        }
        System.out.println("Введіть індекс партії з якої хочете видалити депутата: ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Faction f:factions
            ) {
                if (tempInd==index){
                    f.removeDeputy();
                    break;
                }
                else index++;
            }
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }

    void seeAllBriblesInSomeFaction(){
        Iterator<Faction> iterator = factions.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Фракція "+iterator.next().toString());
            index++;
        }
        System.out.println("Введіть індекс партії з якої хочете вивести всіх хабарників ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Faction f:factions
            ) {
                if (tempInd==index){
                    f.seeAllBriblers();
                    break;
                }
                else index++;
            }
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }

    void theBiggestSizeOfBribleInSomeFaction(){
        Iterator<Faction> iterator = factions.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Фракція "+iterator.next().toString());
            index++;
        }
        System.out.println("Введіть індекс партії з якої хочете вивести найбільшого хабарника ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Faction f:factions
            ) {
                if (tempInd==index){
                    f.theBiggestSizeOfBribe();
                    break;
                }
                else index++;
            }
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }

    void seeAllDeputiesInSomeFaction(){
        Iterator<Faction> iterator = factions.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Фракція "+iterator.next().toString());
            index++;
        }
        System.out.println("Введіть індекс партії з якої хочете вивести всіх депутатів ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Faction f:factions
            ) {
                if (tempInd==index){
                    f.seeAllDeputies();
                    break;
                }
                else index++;
            }
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }

    void clearSomeFaction(){
        Iterator<Faction> iterator = factions.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Фракція "+iterator.next().toString());
            index++;
        }
        System.out.println("Введіть індекс партії яку бажаєте очистити ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Faction f:factions
            ) {
                if (tempInd==index){
                    f.deleteAllDeputiesFromFaction();
                    break;
                }
                else index++;
            }
        }
        catch (IllegalArgumentException exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }

    void giveBribleToDeputyFromSomeFaction(){
        Iterator<Faction> iterator = factions.iterator();
        int index = 0;
        while (iterator.hasNext()){
            System.out.println("Індекс: "+index+" Фракція "+iterator.next().toString());
            index++;
        }
        System.out.println("Введіть індекс партії в якій знаходиться потрібний вам депутат ");
        try{
            Scanner scanner = new Scanner(System.in);
            int tempInd = scanner.nextInt();
            index = 0;
            for (Faction f:factions
            ) {
                if (tempInd==index){
                    f.brible();
                    break;
                }
                else index++;
            }
        }
        catch (Exception exception){
            System.out.println("Ви щось не так ввели. Перевірте тип та правильність вашого вводу! ");
        }
    }
}
