package Low_Level_Design.Design_Patterns.Creational.builder;


import java.util.Scanner;

class Bed{

    String display(){
        return "";
    }
}

class SingleBed extends Bed{
    private int length;
    private int width;
    private String bedFrameMaterial;

    // optional attributes

    private String color;
    private String headBoardStyle;
    private boolean builtInUSB;
    private boolean LEDLightning;

    SingleBed(BedBuilder bedBuilder){
        this.length = bedBuilder.length;
        this.width = bedBuilder.length;
        this.bedFrameMaterial = bedBuilder.bedFrameMaterial;
        this.color = bedBuilder.color;
        this.headBoardStyle = bedBuilder.headBoardStyle;
        this.builtInUSB = bedBuilder.builtInUSB;
        this.LEDLightning = bedBuilder.LEDLightning;
    }

    public String display(){
        return "length: " + length + " " + "width: " + width + " " + "bed frame material: " + bedFrameMaterial + " " + "color: " + color + " "
                + "headboard style: " + headBoardStyle + " " + "buildt in USB: " + builtInUSB + " "
                + "LED lightning: " + LEDLightning;
    }


}

class DoubleBed extends Bed{
    private int length;
    private int width;
    private String bedFrameMaterial;

    // optional attributes

    private String color;
    private String headBoardStyle;
    private boolean builtInUSB;
    private boolean LEDLightning;

    DoubleBed(BedBuilder bedBuilder){
        this.length = bedBuilder.length;
        this.width = bedBuilder.length;
        this.bedFrameMaterial = bedBuilder.bedFrameMaterial;
        this.color = bedBuilder.color;
        this.headBoardStyle = bedBuilder.headBoardStyle;
        this.builtInUSB = bedBuilder.builtInUSB;
        this.LEDLightning = bedBuilder.LEDLightning;
    }

    public String display(){
        return "length: " + length + " " + "width: " + width + " " + "bed frame material: " + bedFrameMaterial + " " + "color: " + color + " "
                + "headboard style: " + headBoardStyle + " " + "buildt in USB: " + builtInUSB + " "
                + "LED lightning: " + LEDLightning;
    }

}


abstract class BedBuilder{

    public int length;
    public int width;
    public String bedFrameMaterial;

    // optional attributes with default
    public String color = "default";
    public String headBoardStyle = "default";
    public boolean builtInUSB = false;
    public boolean LEDLightning = false;


    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setBedFrameMaterial(String bedFrameMaterial) {
        this.bedFrameMaterial = bedFrameMaterial;
    }


    //methods to set optional attributes
    public BedBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public BedBuilder setHeadBoardStyle(String headBoardStyle) {
        this.headBoardStyle = headBoardStyle;
        return this;
    }

    public BedBuilder setBuiltInUSB(boolean builtInUSB) {
        this.builtInUSB = builtInUSB;
        return this;
    }

    public BedBuilder setLEDLightning(boolean LEDLightning) {
        this.LEDLightning = LEDLightning;
        return this;
    }

    public Bed getBed(){
        return new Bed();
    }


}

class SingleBedBuilder extends BedBuilder{

    @Override
    public SingleBed getBed(){
        return new SingleBed(this);
    }
}

class DoubleBedBuilder extends BedBuilder{


    public DoubleBed getBed(){
        return new DoubleBed(this);
    }
}

class Director{

    void createSingleBed(BedBuilder bedBuilder){
        bedBuilder.setLength(190);
        bedBuilder.setWidth(90);
        bedBuilder.setBedFrameMaterial("wooden");

    }

    void createQueenBed(BedBuilder bedBuilder){
        bedBuilder.setLength(190);
        bedBuilder.setWidth(140);
        bedBuilder.setBedFrameMaterial("wooden");

    }

    void createKingBed(BedBuilder bedBuilder){
        bedBuilder.setLength(200);
        bedBuilder.setWidth(150);
        bedBuilder.setBedFrameMaterial("wooden");
    }
}


public class BuilderClient {

    public static void main(String[] args) throws Exception {

        System.out.println("What type of account do you want? \n 1. Single \n 2. Queen Size \n 3. King Size \n 4. Custom");

        Scanner s = new Scanner(System.in);
        int typeOfBed = s.nextInt();

        Director director = new Director();
        BedBuilder bedBuilder;
        Bed bed;

        switch (typeOfBed) {
            case 1:
                bedBuilder = new SingleBedBuilder();
                director.createSingleBed(bedBuilder);
                Bed singleBed = bedBuilder.getBed();
                System.out.println(singleBed.display());
                break;

            case 2:
                bedBuilder = new DoubleBedBuilder();
                director.createQueenBed(bedBuilder);
                Bed queenBed = bedBuilder.getBed();
                System.out.println(queenBed.display());
                break;

            case 3:
                bedBuilder = new DoubleBedBuilder();
                director.createKingBed(bedBuilder);
                Bed kingBed = bedBuilder.getBed();
                System.out.println(kingBed.display());
                break;
            case 4:
                System.out.println("Here client will specify custom bed specs and without the help of director class, builder will create a bed class");
                break;
            default:
                throw new Exception("Invalid option, choose from above options");
        }
        s.close();
    }

}
