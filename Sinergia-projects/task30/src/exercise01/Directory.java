package exercise01;

import java.util.ArrayList;

    class Directory extends FileSystemEntry {
        private ArrayList entries;

        public Directory(String name, String creationDate) {
            super(name, creationDate);
            this.entries = new ArrayList();
        }

        public void addEntry(FileSystemEntry entry) {
            entries.add(entry);
        }

        public ArrayList getEntries() {
            return entries;
        }

        public String toString() {
            return "Директория: " + super.toString() + ", Содержит: " + entries.size() + " записи";
        }
    }
