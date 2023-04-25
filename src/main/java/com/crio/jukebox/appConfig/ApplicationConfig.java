package com.crio.jukebox.appConfig;



import com.crio.jukebox.Services.ISongServie;
import com.crio.jukebox.Services.PlayListService;
import com.crio.jukebox.Services.PlayListServiceImpl;
import com.crio.jukebox.Services.SongsService;
import com.crio.jukebox.Services.UserService;
import com.crio.jukebox.Services.UserServiceImpl;
import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.commands.PlayPlaylist;
import com.crio.jukebox.commands.PlaySong;
import com.crio.jukebox.commands.DeletePlayList;
import com.crio.jukebox.commands.LoadSongsCommand;
import com.crio.jukebox.commands.ModifyPlayList;
import com.crio.jukebox.commands.CreatePlayListCommand;
import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.repositories.IsongRepository;
import com.crio.jukebox.repositories.PlayListRepositoryImpl;
import com.crio.jukebox.repositories.PlaylistRepository;
import com.crio.jukebox.repositories.SongsRepository;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.repositories.UserRepositoryImpl;

public class ApplicationConfig {
   
    private final  IsongRepository songsRepository = new SongsRepository();
    private final  ISongServie songsService = new SongsService(songsRepository);
    private final  LoadSongsCommand loadSongsCommand = new LoadSongsCommand(songsService);

    private final  UserRepository userRepository = new  UserRepositoryImpl();
    private final  UserService userService = new UserServiceImpl(userRepository);
    private final  CreateUserCommand  createUserCommand = new CreateUserCommand(userService);

    private  final  PlaylistRepository playlistRepository = new  PlayListRepositoryImpl();
    private final  PlayListService playListService = new PlayListServiceImpl(playlistRepository, songsService);
    private  final  CreatePlayListCommand createPlayListCommand = new CreatePlayListCommand(playListService);

    private final DeletePlayList deletePlayList = new DeletePlayList(playListService);

    private  final  ModifyPlayList modifyPlayList = new  ModifyPlayList(playListService,songsService);

    private  final  PlayPlaylist playPlaylist = new PlayPlaylist(playListService);

    private  final PlaySong playSong = new PlaySong(playListService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getSongsInvoker(){

          commandInvoker.register("LOAD-DATA" ,loadSongsCommand);
          commandInvoker.register("CREATE-USER",createUserCommand);
          commandInvoker.register("CREATE-PLAYLIST", createPlayListCommand);
          commandInvoker.register("DELETE-PLAYLIST", deletePlayList);
          commandInvoker.register("MODIFY-PLAYLIST", modifyPlayList);   
          commandInvoker.register("PLAY-PLAYLIST", playPlaylist);
          commandInvoker.register("PLAY-SONG", playSong);
          
          
        // commandInvoker.register("CREATE_QUESTION",createQuestionCommand);
        // commandInvoker.register("LIST_QUESTION",listQuestionCommand);
        // commandInvoker.register("CREATE_CONTEST",createContestCommand);
        // commandInvoker.register("LIST_CONTEST",listContestCommand);
        // commandInvoker.register("ATTEND_CONTEST",attendContestCommand);
        // commandInvoker.register("RUN_CONTEST",runContestCommand);
        // commandInvoker.register("LEADERBOARD",leaderBoardCommand);
        // commandInvoker.register("WITHDRAW_CONTEST",withdrawContestCommand);
        return commandInvoker;
    }
}
