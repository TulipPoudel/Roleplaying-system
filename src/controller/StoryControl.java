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
        pushStory(new Story("The Lost Kingdom", "You wake up in a ruined kingdom.", "Easy"));
        pushStory(new Story("Shadow Forest", "Dark creatures roam the forest.", "Medium"));
        pushStory(new Story("Dragon’s Trial", "Face the ancient dragon.", "Hard"));
        pushStory(new Story("Desert of Echoes", "Voices guide your path.", "Medium"));
        pushStory(new Story("Frozen Throne", "Claim the icy throne.", "Hard"));
    }

    
    private void pushStory(Story story) {
        storyStack.push(story);
        story.addDefaultChoices();
        tableModel.addRow(new Object[]{
            story.getTitle(),
            story.getIntro(),
            story.getDifficulty()
        });
    }

    
    public void addStory(String title, String intro, String difficulty) {
        if (title.isEmpty() || intro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }

        pushStory(new Story(title, intro, difficulty));
    }

    
    public void updateStory(String title, String intro, String difficulty) {
        int row = storyTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a story to update");
            return;
        }

        Story story = storyStack.get(row);
        story.setTitle(title);
        story.setIntro(intro);
        story.setDifficulty(difficulty);

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
        return storyStack.get(index);
    }

    public int size() {
        return storyStack.size();
    }
}