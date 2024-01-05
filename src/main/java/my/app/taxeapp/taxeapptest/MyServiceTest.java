package my.app.taxeapp.taxeapptest;
import my.app.taxeapp.bean.Categorie;
import my.app.taxeapp.bean.User;
import my.app.taxeapp.repository.CategorieRepository;
import my.app.taxeapp.repository.UserRepository;
import my.app.taxeapp.service.CategorieService;
import my.app.taxeapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private CategorieRepository categorieRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CategorieService categorieService;
    @InjectMocks
    private UserService userService;
    @Test
    public void testSaveCategorie() {
        Categorie categorie = new Categorie();
        when(categorieRepository.save(categorie)).thenReturn(categorie);

        Categorie savedCategorie = categorieService.createCategory(categorie);

        verify(categorieRepository).save(categorie);
    }
    @Test
    public void testSaveUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.createUser(user);

        verify(userRepository).save(user);
    }
  }