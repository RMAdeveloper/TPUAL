package tp.ual.tp3.data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by A125789 on 07/02/2016.
 */
public class Mail {
    private String subject;
    private String from;
    private String message;

    public Mail(String subject, String from, String message) {
        this.subject = subject;
        this.from = from;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static List<Mail> getList() {
        return Arrays.asList(
                new Mail("Donec non convallis arcu, vel.", "Eos@gmail.com","Id equidem apeirian corrumpit nam, iriure nominavi imperdiet pri at, dicat phaedrum ne vim. Nam in omnis ubique delenit, legendos suavitate ex eum. Cu sale docendi incorrupte qui. Quod ancillae constituto ex nam. Sea at eripuit dolorem insolens, justo graece has te."),
                new Mail("Ut eget aliquet nulla.", "Sea@gmail.com","Putant principes scripserit vis ex. Has at wisi ullum. Consul nemore eum ex. At nam porro ullum, ei sea dicit molestie pertinacia, ne vix aliquam facilisis expetenda. Nec sint minim salutandi ut. Decore omittam dissentias usu ut, eu sed reque patrioque, ne eum erat idque evertitur. Vel ei tale nostrud ornatus, an nonumy verear complectitur vel, et vel mutat harum civibus."),
                new Mail("Sed commodo tincidunt nibh", "Recteque@gmail.com","Et mea cibo movet. Vix et eripuit mentitum, vim ex agam nibh suscipit. Est dicat adipisci invenire in, quo et aliquam maluisset dissentias. Eu consul epicuri perpetua duo, et commodo appetere vim, mea omnis officiis efficiantur ea.\n"),
                new Mail("Lorem ipsum dolor sit.", "Latine@gmail.com","Eu eam debet repudiare moderatius, stet mutat interesset in has. Ex postea labores percipit vix, has elitr legendos gubergren et. Ut tritani utroque eam, mea ad insolens repudiare. Iisque veritus mei ad, et his noster oporteat facilisi."),
                new Mail("Fabulas detraxit per no.", "Nam@gmail.com","Vim eu inani persius nostrud. Usu ex dolor instructior, adhuc debet pri at, sit at esse doming dicunt. Eum ei clita exerci complectitur. Mazim pertinacia at mei, vel et utamur tractatos."),
                new Mail("Per et ludus perfecto.", "Quot@gmail.com","Wisi partiendo ad est, cu sale nemore fastidii quo, cibo putent accumsan vel id. Postea tritani nec id. Ne scaevola interpretaris duo, propriae expetendis ius eu. Eum ex vidit iudico perpetua, per regione perfecto at. Pro cu graeci nominati persecuti, cu wisi oblique quaerendum vis."),
                new Mail("Ex assum interesset dissentiet.", "Nec@gmail.com","Tacimates periculis ea vim, cetero voluptaria dissentiet at eum. Et omnes ornatus indoctum mel, et mea doctus fastidii detraxit. Ne inciderint definitiones mei, ut atqui scribentur has. No eum iisque corpora, saepe vocibus eu his, ad mei audire sapientem consequuntur.\n"),
                new Mail("Eum cu facer numquam.", "His@gmail.com","Usu cibo docendi ei, in omnis ubique fastidii usu, ut patrioque prodesset nam. Eam inani inimicus in, te qui quas partiendo percipitur. At sit tota suscipiantur. Causae menandri mei ea, et sea eruditi fuisset, munere quidam sententiae ne usu."),
                new Mail("Duo dicunt omittantur an.", "Graecis@gmail.com","Ex mentitum indoctum vel, no atqui nominati his, per id sint aperiam. At nobis debitis necessitatibus usu. Ut zril abhorreant delicatissimi usu, eum natum prima suavitate eu. Soleat abhorreant ne sed, ne mel doctus equidem."),
                new Mail("Et sea cibo percipit.", "Ei@gmail.com","Id ius veniam nusquam apeirian. Partem corrumpit qui in. Ei sit summo appetere. Ex graece eruditi consetetur per, sed aliquid delicatissimi ea. At vel voluptua rationibus disputando, populo aliquam sed ea."),
                new Mail("Eum accusata nominati te.", "Ad@gmail.com","Cu sed assum euripidis, mea no nibh vidisse repudiare. Atqui convenire suscipiantur sed no, sit id salutatus dignissim. Luptatum consetetur mea ea. Graeci consetetur pro ut, in dicant euismod assentior mei. Quo id utinam verterem."),
                new Mail("Ius esse nihil intellegat.", "Labitur@gmail.com","Eum ex dico soluta sadipscing, id mei amet fierent accusamus, doming periculis posidonium vim ei. Te usu quot veniam vocibus. Solum idque an usu, ei mei tractatos aliquando forensibus. Nam eu dictas temporibus, latine dolorem civibus ad mea. Illud partem quo an."),
                new Mail("Nec erat nostrud at.", "Veniam@gmail.com","Et vis assum integre, pri ne diam iusto persius. Nostro honestatis id vim. Eos ei laudem propriae liberavisse, vide deseruisse pri id, stet libris inimicus usu te. An eos illum corrumpit, eu simul intellegat mei. Nec autem aperiri te, rebum oratio inermis quo an.")
        );
    }
}
