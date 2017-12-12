import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Missing file argument. Usage: mima [filename]");
            return;
        }
        Path filePath = Paths.get(args[0]);

        if (!Files.exists(filePath))
        {
            System.out.println("File doesn't exist");
            return;
        }

        List<String> file;
        try
        {
            file = Files.readAllLines(filePath);
            List<Instruction> instructions = readCodeFile(file);

            int i = 0;
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
    }

    private static List<Instruction> readCodeFile(List<String> file) throws Exception
    {
        List<Instruction> instructions = new ArrayList<>();

        for (int i = 0; i < file.size(); i++)
        {
            String line = file.get(i);
            String[] columns = line.split(" ");

            Instruction instruction = new Instruction();

            if (columns.length == 0)
                throw new Exception("Empty line " + ++i);
            instruction.setName(columns[0]);

            if (columns.length > 1)
                instruction.setArgument(columns[1]);

            instructions.add(instruction);
        }

        return instructions;
    }
}
