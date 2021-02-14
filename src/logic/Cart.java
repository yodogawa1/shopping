package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return this.itemList;
	}

	public boolean isEmpty() {
		if (this.itemList == null || this.itemList.isEmpty()) {
			return true;
		}
		return false;
	}

	public void push(ItemSet pushedItemSet) {
		// �ǉ����i���J�[�g�Ɋ��ɑ��݂��邩���m�F����t���O
		boolean itemExistInCart = false;

		// �ǉ����ꂽ���i�̏��iID���擾
		Item pushedItem = pushedItemSet.getItem();
		int pushedItemId = pushedItem.getItemId().intValue();

		// �J�[�g�̏��i�̐��������[�v
		for (ItemSet cartItemSet : this.itemList) {

			// �J�[�g���̏��i�̏��iID���擾
			Item cartItem = cartItemSet.getItem();
			int cartItemId = cartItem.getItemId().intValue();

			if (cartItemId == pushedItemId) {
				// ����ID�̏��i���J�[�g�ɑ��݂���ꍇ�A���ʂ̂݉��Z
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				// �ǉ����i���J�[�g���Ɋ��ɑ��݂���
				itemExistInCart = true;
				break;
			}
		}

		if (!itemExistInCart) {
			// �J�[�g�ɓ��ꏤ�i���Ȃ������̂Œǉ�
			this.itemList.add(pushedItemSet);
		}
	}

	public void clearAll() {
		this.itemList = new ArrayList<ItemSet>();
	}
}