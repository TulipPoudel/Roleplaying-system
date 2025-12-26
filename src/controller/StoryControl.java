package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Story;

public class StoryControl {

    private ArrayList<Story> stories;
    private DefaultTableModel tableModel;
    private JTable storyTable;

    public StoryControl(ArrayList<Story> stories, JTable storyTable) {
        this.stories = stories; 
        this.storyTable = storyTable;
        this.tableModel = (DefaultTableModel) storyTable.getModel();

        preloadStories(); 
    }

    
    private void preloadStories() {
        addStoryInternal(new Story("The Lost Kingdom", "You wake up in a ruined kingdom.", "Easy"));
        addStoryInternal(new Story("Shadow Forest", "Dark creatures roam the forest.", "Medium"));
        addStoryInternal(new Story("Dragon’s Trial", "Face the ancient dragon.", "Hard"));
        addStoryInternal(new Story("Desert of Echoes", "Voices guide your path.", "Medium"));
        addStoryInternal(new Story("Frozen Throne", "Claim the icy throne.", "Hard"));
    }

    
    private void addStoryInternal(Story story) {
        stories.add(story);
        story.addDefaultChoices();
        tableModel.addRow(new Object[]{
            story.getTitle(),
            story.getDifficulty()
        });
    }

    
    public void addStory(String title, String intro, String difficulty) {
        if (title.isEmpty() || intro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }

        Story story = new Story(title, intro, difficulty);
        addStoryInternal(story);
    }

    
    public void updateStory(String title, String intro, String difficulty) {
        int selectedRow = storyTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a story to update");
            return;
        }

        Story story = stories.get(selectedRow);
        story.setTitle(title);
        story.setIntro(intro);
        story.setDifficulty(difficulty);

        tableModel.setValueAt(title, selectedRow, 0);
        tableModel.setValueAt(difficulty, selectedRow, 1);
    }

    
    public void deleteStory() {
        int selectedRow = storyTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a story to delete");
            return;
        }

        stories.remove(selectedRow);
        tableModel.removeRow(selectedRow);
    }

    
    public Story getStory(int index) {
        return stories.get(index);
    }

    public ArrayList<Story> getAllStories() {
        return stories;
    }
}