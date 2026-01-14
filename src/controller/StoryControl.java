package controller;

import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Story;

public class StoryControl {

    private Stack<Story> storyStack = new Stack<>();
    private DefaultTableModel tableModel;
    private JTable storyTable;

    public StoryControl(JTable storyTable) {
        this.storyTable = storyTable; 
        this.tableModel = (DefaultTableModel) storyTable.getModel();

        preloadStories(); 
    }

    
    private void preloadStories() {
        addStory("The Lost Kingdom", "You wake up in a ruined kingdom.", "Easy");
        addStory("Shadow Forest", "Dark creatures roam the forest.", "Medium");
        addStory("Dragon’s Trial", "Face the ancient dragon.", "Hard");
        addStory("Desert of Echoes", "Voices guide your path.", "Medium");
        addStory("Frozen Throne", "Claim the icy throne.", "Hard");
    }

    
    public void addStory(String title, String intro, String difficulty) {
        
        if (title.isEmpty() || intro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }
        
        Story s = new Story(title, intro, difficulty);
        
        storyStack.add(s);

        tableModel.addRow(new Object[]{
            title, intro, difficulty
        });
        
        
    }

    
    public void updateStory(String title, String intro, String difficulty) {
        int row = storyTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a story to update");
            return;
        }

        Story s = storyStack.get(row);
        s.setTitle(title);
        s.setIntro(intro);
        s.setDifficulty(difficulty);

        tableModel.setValueAt(title, row, 0);
        tableModel.setValueAt(intro, row, 1);
        tableModel.setValueAt(difficulty, row, 2);
    }

    
    public void deleteStory() {
        int row = storyTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a story to delete");
            return;
        }

        storyStack.remove(row);
        tableModel.removeRow(row);
    }

    
    public Story getStory(int index) {
        if (index < 0 || index >= storyStack.size()) {
            return null;
        }
        return storyStack.get(index);
    }

    public int getStoryCount() {
        return storyStack.size();
    }
}