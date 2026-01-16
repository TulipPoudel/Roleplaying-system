package controller;

import java.util.ArrayList;
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
    
    public Story findStoryByTitle(String title) {
        for (int i = 0; i < getStoryCount(); i++) {
            Story s = getStory(i);
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }
    
    private ArrayList<Story> getStoryList() {
        return new ArrayList<>(storyStack);
    }
    
    public void sortStoriesByTitle() {
        ArrayList<Story> list = getStoryList();
        mergeSort(list, 0, list.size() - 1);

        storyStack.clear();
        tableModel.setRowCount(0);

        for (Story s : list) {
            storyStack.add(s);
            tableModel.addRow(new Object[]{
                s.getTitle(), s.getIntro(), s.getDifficulty()
            });
        }
    }

    private void mergeSort(ArrayList<Story> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(ArrayList<Story> list, int left, int mid, int right) {
        ArrayList<Story> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).getTitle().compareToIgnoreCase(
                list.get(j).getTitle()) <= 0) {
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }

        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }
    
    public Story binarySearchByTitle(String key) {
        ArrayList<Story> list = getStoryList();

        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = list.get(mid).getTitle()
                    .compareToIgnoreCase(key);

            if (cmp == 0) return list.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public int getStoryCount() {
        return storyStack.size();
    }
}