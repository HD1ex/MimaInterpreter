import javax.rmi.CORBA.Util;
import java.util.*;

public class Mima
{
    private int accu;
    private Map<String, Integer> memory = new HashMap<>();

    public void execute(List<Instruction> instructions)
    {
        for (int line = 0; line < instructions.size(); line++)
        {
            Instruction instruction = instructions.get(line);

            switch (instruction.getName())
            {
                case "LDC":
                    accu = Integer.parseInt(instruction.getArgument());
                    break;
                case "STV":
                    memory.put(instruction.getArgument(), accu);
                    break;
                case "HALT":
                    return;
            }
        }
    }

    public void printState()
    {
        System.out.println("Accu:\t" + accu);

        System.out.println("Memory content:");

        Set<String> keySet = memory.keySet();

        for (String key : keySet)
        {
            System.out.println("Address:\t" + key + "\tValue:\t" + memory.get(key));
        }
    }
}
