# <a name="sction0">Githubやってみよう
ソースコードのバージョン管理を行うにあたって、Git（Github）を使用しようと思います。  
このテキストは、Android勉強会の一環として使用する目的が云々・・・

正しく使えば便利、正しく使えないと大変なことになるので、  
ある程度のレベルで使えるようになったらいいな

***

## もくじ
* [バージョン管理とはなんぞや](#section1)
  * バージョン管理とは
  * ソースコードをバージョン管理する意味
  * SVNとGit
  * GitとGithub
* [導入](#section2)
  * アカウント作成
  * 開発レポジトリへの招待
* [必要なもの](#section3)
  * Gitbash
  * SourceTree
* [使ってみる](#section4)
  * おやくそく
    * GitFlow
      * 各ブランチのやくわり
        * master
        * develop
        * feature
  * 開発の一連の流れ
    1. プロジェクトをクローンする
    1. developを最新化する
    1. developからトピックブランチを作成する
    1. 作成したトピックブランチで開発する
      * トピックブランチへ変更をコミットする
    1. トピックブランチをプッシュする
    1. developへプルリクエストを出す
      * レビューにて指摘があれば修正する
    1. プルリクエストをマージする
* [参考になりそうなサイト](#section5)

***

## <a name="section1">バージョン管理とはなんぞや
### バージョン管理とは
ソースコードなどで、開発した経過をバージョンをつけて保存することができ、  
バージョンごとの比較や、古いバージョンへ戻すといった処理を簡単にできる。  

バージョンごとにコメントを残せるので、  
適切なコメントがあれば何の変更かが他者から分かりやすい。

### ソースコードをバージョン管理する意味
この機能いつ入ったっけ、このコード変更されているけど、  
いつ何の対応でのことだっけ、とか知りたい  
って時。

神からの掲示があり、一気に機能の実装を進めたが、ビルドしてみると全く動かなくなった・・・  
どの変更が影響しているのかわからないよー、どこを弄ったかおぼえてないよー  
って時。

最新版をリリースしたけど、トラブって動かなくなった！  
とりあえず旧版をリリースしなおして事なきを得たい  
って時。

などなど

### SVNとGit
参考サイト：[Subversion 対 Git：どちらを使うべきなのか？いろいろな観点から比較してみた](https://tracpath.com/works/development/subversion_vs_git/)  
* SVN  
    Subversionが正式名称。  
    集中型のバージョン管理システム。  
    コミットした内容は、サーバ上でのみ管理される。  
    ひとつのリポジトリに対して、開発者が変更内容を反映させていくイメージ。
* Git  
    分散型のバージョン管理システム。  
    サーバ上にあるリポジトリから、自分のローカルへリポジトリのクローンを作成する。  
    変更内容は、ローカルのリポジトリにてバージョン管理し、  
    開発の区切りのタイミングで、サーバ上のリポジトリへ、変更内容を反映させる。

### GitとGithub
wikiとwikipediaみたいな関係  
Gitは仕組み、システム自体の名称。  
GithubはGitのシステムを提供しているサービスの名前。  
Gitのシステムを使用できるサービスとかは、Github以外にも色々ある。
* Gitlub
* Bitbacket
* etc...


[TOP](#section0)

***

## <a name="section2">導入
### アカウントの作成
[Github](https://github.com/)のページからもにょもにょする

### 開発リポジトリへの招待
[実験用リポジトリ](https://github.com/ykishi0531/sandbox)  
作成したGithubアカウントのユーザー名を教えてください。  
リポジトリの作成者、もしくはリポジトリへ開発者として招待されたユーザーのみが  
リポジトリに対して変更を送信することが出来ます。

[TOP](#section0)

***

## <a name="section3">必要なもの
Gitを使うにあたって、  
* 変更内容を保存したり  
* 他の人の変更を取り込んだり  
* 変更内容の確認をしたり  

するために必要なツール。  
とりあえずどちらか使いやすい方でいいかとー

### Gitbash
[git for windows](https://git-for-windows.github.io/)  
CUI（コマンドライン）でgitの操作が可能。  
viとかtailとかwindowsでできるよ！

### SourceTree
[Atlassian SoueceTree](https://ja.atlassian.com/software/sourcetree)  
GUIだから使いやすい？  
Atlassianのアカウントが必要。

[TOP](#section0)

***

## <a name="section4">使ってみる
運用ルールと実際の一連の流れと

### おやくそく
Gitのまわし方には、メジャーなフローがいくつかあります  
[GitFlow](http://nvie.com/img/git-model@2x.png)  
[GithubFlow](http://www.nicoespeon.com/assets/img/git/github-flow-branching-model.jpg)  
GithubFlowは使った事ないので、とりあえずGitFlowで進めたい  

#### GitFlow
フロー図には、ブランチいっぱい書かれているけど  
以下のブランチの役割を抑えておけばOK  
今回説明していないブランチについては、開発が進んだ段階で必要になったらお話、ってことで

##### 各ブランチのやくわり
* master  
  現在リリースされているプログラムが管理されるブランチ。  
  developでの開発を終え、リリースを行う際に  
  develop→masterへのマージを行い、masterブランチからリリースを行う。  
  masterブランチは、いついかなる時でもリリース可能な状態を保っている。  
  masterブランチへ直接コミット・プッシュを行うことは、基本的に無い。  
* develop  
  開発ブランチ  
  featueブランチにて開発された機能をマージしていく。  
  各featureブランチからプルリクエストを出すブランチがここ。  
  developブランチへ直接コミット・プッシュを行うことは、基本的に無い。  
* feature  
  トピックブランチ  
  開発中の機能ごとに作成されるブランチ  
  トピックブランチ内での開発が終わった段階で  
  developブランチへプルリクエストを出す。  
  ブランチ名は「feature/（機能名）」などのようにすると、SourceTreeで幸せになれる

### 開発の一連の流れ
一旦Gitbashのみ。  
余裕があったらSourceTree版も書きたい  
httpsとSSHとあるけど、httpsのみ。  
興味がある方、楽をしたい方はSSHを調べると良いかも

1については初回のみ。  
開発は２～７の流れをぐるぐるする感じ

1. プロジェクトをクローンする。  
  `git clone -b develop https://github.com/ykishi0531/sandbox.git`  
  gitのsandboxリポジトリから、developブランチをcloneする
2. developを最新化する  
  `git checkout develop` - developブランチに切り替える  
  `git fetch origin develop` - リモートリポジトリの内容をローカルリポジトリに取り込む  
  `git merge origin/develop` - ローカルリポジトリの内容をローカルプロジェクトに取り込む  
3. developからトピックブランチを作成する  
  `git branch feature/（機能名)` - ローカルリポジトリにブランチを作成する  
  `git checkout feature/（機能名)` - 作成したブランチに切り替える
4. トピックブランチで開発する  
  ごりごり開発して、キリの良いところでコミットして、  
  変更内容を保存しましょう  
  * トピックブランチへの変更をコミットする  
    * `git status`  
      ブランチの状態と、ファイルの変更状態を確認する。  
    * `git add （ファイルパス）`  
      変更を加えたファイルから、コミットしたいものをコミット対象にする（ステージングエリアへ追加する）  
    * `git commit`  
      ステージングエリアにあるファイルを、ローカルブランチへコミットする。  
      コミット時に、どういった内容のコミットなのかメッセージを入れる（必須）  
      * `-m "(コミットメッセージ)"`  
        メッセージをつけてコミット  
    * `git log`  
      コミットが正常にされたことを確認する  
      * `--name-status`  
        コミットされたファイル名を確認する  
      * `--oneline`  
        ログを1行表示にしてみやすくする  

5. トピックブランチをプッシュする  
  * `git push origin feature/（機能名）`  
    * ID/passwordを入力してリモートのブランチへプッシュする。  
    * リモートにブランチが無ければ新規で作成し、あれば追加コミット分をプッシュする  
    * [Github](https://github.com/ykishi0531/sandbox)  
      * Branchプルダウンから、プッシュしたブランチを選択し、変更内容が送信されていることを確認する。  
6. developへプルリクエストを出す
  * [Github](https://github.com/ykishi0531/sandbox)  
   New pull requestボタンからプルリクエストを作成する （向き先に注意）  
  「base」プルリクエストを送る先（今回はdevelop固定）  
  「compare」プルリクエストを送る元のブランチ（fatureブランチ）  
  baseとcompareの差分が表示されるので、意図した変更差分のみな事を確認して  
  Create pull request

7. プルリクエストをマージする  
  [Github](https://github.com/ykishi0531/sandbox)  
  Pull requestタブ内に、作成したプルリクエストがあるので、  
  自分以外のレビュアーにレビューしてもらい、OKが出たら  
  Merge pull request

  レビューにて指摘があり、変更を適用したい場合は  
  プルリクエストはそのまま、ローカルのトピックブランチにて修正＆コミット＆プッシュすると  
  プルリクエストに、プッシュした内容が反映される  

[TOP](#section0)

***

## <a name="section5">参考になりそうなサイト
* [Git 再入門 リモートリポジトリを使った作業](http://www.yunabe.jp/docs/relearning_git_remote.html)  
* [基本的なGitコマンドまとめ](http://qiita.com/2m1tsu3/items/6d49374230afab251337)

[TOP](#section0)
