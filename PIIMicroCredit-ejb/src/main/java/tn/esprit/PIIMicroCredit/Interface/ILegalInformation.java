package tn.esprit.PIIMicroCredit.Interface;
import javax.ejb.Remote;
import tn.esprit.PIIMicroCredit.entity.LegalInformation;
import tn.esprit.PIIMicroCredit.entity.User;


@Remote
public interface ILegalInformation {
	public int addLegalInfo(LegalInformation C);
	public void removeLegalInfo(int id);
	public void updateLegalInfo(LegalInformation C);
	public LegalInformation FindLegalInfoById(int id);
	public LegalInformation FindLegalInfoByUserId(User user);
}
