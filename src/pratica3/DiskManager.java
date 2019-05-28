package pratica3;

import java.util.Arrays;

public class DiskManager {
	Block[] disk;
	int freeSpaces;

	private class Block {
		int nBlock;
		SystemObject fileBlock;
		Block nextBlock;

		Block(int nBlock, SystemObject fileBlock, Block nextBlock) {
			this.nBlock = nBlock;
			this.fileBlock = fileBlock;
			this.nextBlock = nextBlock;
		}
		
		@Override
		public String toString() {
			return "Blk("+ nBlock + ") obj (" + fileBlock.getName() + ")\n";
		}
	}

	public DiskManager(int size) {
		disk = new Block[size];
		freeSpaces = disk.length;
	}

	public void allocateDirectory(Directory d) {
		if (freeSpaces >= 1) {
			for (int i = 0; i < disk.length; i++) {
				if (disk[i] == null) {
					disk[i] = new Block(0, d, null);
					freeSpaces--;
					break;
				}
			}
		} else {
			System.err.println("No space in disk to allocate");
		}
	}
	
	public void allocateFile(File d, int size) {
		if (freeSpaces >= size) {
			int count = 0;
			Block aux = null;
			for (int i = 0; i < disk.length && count < size; i++) {
				if (disk[i] == null) {
					disk[i] = new Block(count, d, null);
					if (aux != null) {
						aux.nextBlock = disk[i];
					}
					aux = disk[i];
					count++;
					freeSpaces--;
				}
			}
		} else {
			System.err.println("No space in disk to allocate");
		}
	}
	
	public void deallocate(SystemObject d) {
		for (int i = 0; i < disk.length; i++) {
			if (disk[i] != null && disk[i].fileBlock == d) {
				disk[i] = null;
				freeSpaces++;
			}
		}
	}
	
	public int getFreeSpaces() {
		return freeSpaces;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(disk);
	}

}
