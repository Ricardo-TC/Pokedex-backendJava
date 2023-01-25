package Tools;

import Controllers.MoveController;
import Models.MoveModel;

public class PruebaGral {
    public static void main(String[] args) {
        MoveController controller = new MoveController();

        controller.CreateMove(new MoveModel("loquito","2dd","55","25","85"));
    }
}
