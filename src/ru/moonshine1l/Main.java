package ru.moonshine1l;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Данная консольная программа предназначена для добавления текста к картинкам." +
                " Для получения инструкции напишите слово help.");
        while (true) {
            if (scan.nextLine().equals("help")) {
                System.out.print("Доступные команды:" +
                        "mem - добавляет к указанной картинке заданный текст. Например “java -jar\n" +
                        "MemCreator.jar mem ./picture.png ‘hello world’ result.png” – данная команда добавляет текст «hello\n" +
                        "world» к картинке picture.png и сохранит ее в текщей директории под названием result.png!\n"+
                        "exit - после данной команды программа завершит свою работу" +
                        "P.S. Если вы хотите добавить свою картинку, то добавить ее нужно по пути src/ru/moonshine1l/res. " +
                        "Также хочу предупредить, что программа работает только с форматом png");
            } else if (scan.nextLine().equals("mem")) {
                System.out.println("Напишите путь к картинке, которую хотите использовать:");
                String imagePath = scan.nextLine();
                System.out.println("Напишите текст, который хотите добавить к картинке: ");
                String text = scan.nextLine();
                System.out.println("Напишите название, которое хотите дать получившейся фотографии (не забудьте указать формат файла): ");
                String result = scan.nextLine();
                mem(imagePath, text, result);
                System.out.print("Файл успешно сохранен! Вы можете найти его в текущей директории");
            }else if (scan.nextLine().equals("exit")) {
                break;
            } else {
                System.out.print("Введите одну из доступных команд!");
            }
        }
    }

    public static void mem(String imagePath, String text, String result){
        try {
            BufferedImage picture = ImageIO.read(new File("src/ru/moonshine1l/res/" + imagePath));
            Graphics g = picture.getGraphics();
            g.setFont(g.getFont().deriveFont(250f));
            g.setColor(Color.black);
            g.drawString(text, 1000, 1750);
            g.dispose();

            ImageIO.write(picture, "png", new File("./" + result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
