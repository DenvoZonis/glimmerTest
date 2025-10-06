## Task1

Q: 你知道什么是操作系统吗？

A: 操作系统是一堆系统软件的集合，是介于计算机硬件与软件程序的中介和桥梁，主要负责管理计算机上的各种硬件、运行于其上的进程、内存使用、文件读写以及输入输出等。比如我的笔记本电脑上的操作系统是Windows，手机上的操作系统是Android，NAS上的操作系统是Linux。

Q: 安装Linux

A: 我使用VMWare安装Ubuntu 24.04.3。具体的安装步骤如下:

1. 在电脑上安装VMware（由于之前已经安装过，步骤截图省略）
    简单来说就是在[官网](https://support.broadcom.com/group/ecx/productfiles?subFamily=VMware%20Workstation%20Pro&displayGroup=VMware%20Workstation%20Pro%2017.0%20for%20Windows&release=17.6.3&os=&servicePk=undefined&language=EN&freeDownloads=true)上下载这个软件的安装包（需要博通账号登录），然后打开安装包，根据提示完成安装。此处详细步骤省略。
2. 下载Ubuntu 24.04.3
    由于官网在国外，此处使用了清华大学开源软件镜像站来下载Ubuntu的iso镜像。[下载地址](https://mirrors.tuna.tsinghua.edu.cn/ubuntu-releases/24.04.3/ubuntu-24.04.3-desktop-amd64.iso)
3. 创建Ubuntu虚拟机
    打开VMware，点击屏幕左上角、位于菜单栏的“文件”菜单，选择“新建虚拟机”选项，会弹出来一个“新建虚拟机向导”。
    ![点击菜单](1.png)
    ![弹出向导](2.png)
    然后根据以下来操作。
    1. 希望使用什么类型的配置——典型（推荐）
        ![典型](2.png)
    2. 如何安装客户机操作系统——安装程序光盘映像文件（iso）——选择第2步下载好的iso文件
        ![选择iso](3.png)
    3. 个性化Linux（略，就是设置全名、用户名、密码）
        ![个性化Linux](4.png)
    4. 该虚拟机使用什么名称及虚拟机保存位置
        ![选择名称和位置](5.png)
    5. 指定磁盘容量——最大磁盘大小20GB且将虚拟磁盘存储为单个文件
        ![指定磁盘](6.png)
    6. 准备好创建虚拟机——点击“自定义硬件”，并把虚拟机配置设置成一个比较合理的值。比如我的设置：
        - 内存：8GB
        - CPU：1个处理器，4个内核
        - 网络适配器：桥接模式（个人比较喜欢用这个，很多时候方便从各种网络下都能访问到虚拟机）
        
        ![创建虚拟机](7.png)
        ![自定义硬件](8.png)

    如果Windows功能中启用了“虚拟机平台”的（比如想要/已经安装了WSA、WSL、Hyper-V的），就取消勾选“创建后开启此虚拟机”。这些事情都完成后就点击“确定”。

4. 禁用侧通道缓解（可选，针对启用了虚拟机平台的）
    在主页面点击“编辑虚拟机设置”，再点击“选项”标签，找到“高级”选项，勾选“为启用了Hyper-V的主机禁用侧通道缓解”，然后点击“确定”按钮。
    ![主页面](9.png)
    ![操作](10.png)
5. 安装Ubuntu
    1. 在主页面上点击“开启此虚拟机”，并等待直到出现此页面。
        ![开启虚拟机](11.png)
        ![目标页面](12.png)
    2. 鼠标点击虚拟机中的页面，将键鼠输入定向到虚拟机，选择语言为中文，然后点击下一步。
        ![设置中文](13.png)
    3. 一路下一步，直到“连接到互联网”一步。此时使用互联网会连接Ubuntu官方软件源更新软件包，但是速度会比较慢，可以在安装系统后更换国内的软件源后再更新。
        此时点击“我现在不想连接到互联网”选项，然后点击“下一步”。如果后续提示安装程序有更新，也先暂时跳过。
        ![下一步1](14.png)
        ![下一步2](15.png)
        ![我现在不想连接到互联网](16.png)
        ![跳过安装程序更新](17.png)
    4. 安装Ubuntu
        在“使用或安装Ubuntu”一项中选择“安装Ubuntu”，并在接下来使用“交互式安装”。
        ![安装Ubuntu](18.png)
        ![交互式安装](19.png)
    5. “安装应用”选项
        这个看个人喜好，我选择的是默认集合并安装媒体格式的支持。
        ![安装应用](20.png)
        ![媒体支持](21.png)
    6. 调整分区
        这个看个人需求了，只作为学习的话默认的分区也够了，或者通过手动分区把整块硬盘全部挂载到`/`目录。 ~~（懒）~~
        ![分区](22.png)
    7. 设置账户
        根据3.3步的内容填写即可。
        ![设置账户](23.png)
    8. 设置时区&检查设置
        设置时区，设置为上海即可。
        ![时区](24.png)
        最后检查一遍设置，如果没有问题就点击“安装”按钮。
        ![检查](25.png)
    9. 等待安装完成
        出现这个界面就可以等待直到提示重启了。当然你也可以点击右下方的终端按钮查看具体安装过程。提示重启时建议先关机，避免重启时重复进入安装程序。
        ![等待界面](26.png)
        ![安装过程](27.png)
        ![提示重启](28.png)
        ![关机](29.png)
    10. 取消ISO挂载
        点击“编辑虚拟机设置”，把CD/DVD和软盘都调整成“使用物理驱动器”，再点击“确定”。
        ![编辑虚拟机设置](9.png)
        ![取消挂载](30.png)
6. 启动Ubuntu
    点击“开启此虚拟机”，并等待加载至登录页面，输入密码后回车即可登录进入Ubuntu。
    ![启动Ubuntu](31.png)
    ![选择账户](32.png)
    ![登录账户](33.png)
    ![进入Ubuntu](34.png)

至此Linux（Ubuntu）已经安装完成。但为了让它更易用，需要进行一些设置。
1. 关闭欢迎页面
    根据提示快速完成并结束欢迎页面。其中“是否发送可选数据”可根据个人选择，我选择的“不发送可选数据”。
    ![欢迎1](34.png)
    ![欢迎2](35.png)
    ![欢迎3](36.png)
    ![欢迎4](37.png)
    ![进入桌面](38.png)
2. 更换软件源
    Ubuntu提供了一个图形化的更换软件源的方式。按图中箭头所指打开”软件和更新“应用。
    ![打开图形化换源](39.png)
    在打开的页面中，把“下载自”选项改为“其他”，就会弹出如下界面，点击“选择最佳服务器”，并等待测试结果。它会直接选中最佳的服务器，所以直接点击“选择服务器”即可。此时会要求输入密码，出现这种页面的时候都是输你的登陆密码。之后点击“重新载入”，等待页面自动关闭。
    ![下载自](40.png)
    ![选择最佳服务器](41.png)
    ![等待](42.png)
    ![结果](43.png)
    ![密码输入页面](44.png)
    ![关闭](45.png)
    ![重新载入](47.png)
    ![更新软件缓存](48.png)
3. 更新软件
    按如图方式打开终端。
    ![打开终端](46.png)
    输入`sudo apt update`刷新软件源。提示输入密码时也是输入系统的登录密码。注意此时命令行终端不会显示星号“*”来提示输入密码。命令执行结束后，使用`sudo apt upgrade`查看有更新版本的软件包并更新。如果提示有不需要的软件包，可使用`sudo apt autoremove`来卸载它们。（执行过程中需要输入`y`并回车来确定操作）
4. 安装VM Tools
    由于新版VM Tools需要自行下载，所以需要在[这里](https://packages-prod.broadcom.com/tools/frozen/linux/linux.iso)下载一个iso文件，并解压其中的`VMWareTools-*.*.*-***.tar.gz`文件出来，再把这个tar.gz文件的所有内容解压出来。现在我们获得了这些文件：
    ```bash
    ~/VMTools$ tree   //使用sudo snap install tree安装这个软件包
    .
    ├── linux.iso
    ├── VMwareTools-10.3.26-22085142
    │   └── vmware-tools-distrib
    │       ├── bin   //里面的文件夹内容省略
    │       ├── doc   //里面的文件夹内容省略
    │       ├── etc   //里面的文件夹内容省略
    │       ├── FILES
    │       ├── INSTALL -> ./doc/INSTALL
    │       ├── installer   //里面的文件夹内容省略
    │       ├── lib   //里面的文件夹内容省略
    │       ├── vgauth   //里面的文件夹内容省略
    │       └── vmware-install.pl -> ./bin/vmware-uninstall-tools.pl
    └── VMwareTools-10.3.26-22085142.tar.gz

    481 directories, 1464 files
    ```
    输入`sudo VMwareTools-10.3.26-22085142/vmware-tools-distrib/vmware-install.pl`，根据命令行提示（可以一路按回车作为默认值，除了最开始的这个写yes：
    ```bash
    open-vm-tools packages are available from the OS vendor and VMware recommends
    using open-vm-tools packages. See http://kb.vmware.com/kb/2073803 for more
    information.
    Do you still want to proceed with this installation? [no]
    ```
    ）安装VM Tools。如果出现如下内容：
    ```bash
    Enjoy,

    --the VMware team
    ```
    就是安装完成了。安装完成后使用`exit`或者在图形化页面登出：
    ![登出按钮](49.png)
    ![登出提示](50.png)
    随后重新登录即可。

## Task2

Q：简单了解⼀下Linux的⽬录结构。

A： 根目录下有这些文件夹：
```bash
/
├── bin    //一般使用的终端命令等放在这里
├── boot    //启动系统需要的东西，比如引导之类的
├── dev    //硬件设备抽象出来的文件放在这里（一切皆文件的思想）
├── etc    //配置文件存放位置
├── home   //普通用户的家目录
├── lib   //程序的依赖库
├── media   //U盘等东西挂载在这里
├── mnt   //U盘等也能挂载在这里，但这是临时/手动挂载用的
├── opt   //一个软件安装位置
├── proc   //内存中的虚拟文件系统，存储系统和进程信息
├── root   //root用户的家目录
├── sbin   //如重启之类的与系统有关的命令在这里
├── srv   //服务数据目录（如 Web、FTP 的数据）
├── sys   //内核与硬件信息的接口（虚拟文件系统）
├── tmp   //临时文件目录
├── usr
│   ├── bin   //普通用户的可执行程序
│   ├── lib   //普通用户的程序的依赖库
│   └── local   //本地用户安装的软件
└── var   //经常变化的文件放在这里
```

Linux系统与Windows系统不同，没有盘符之类的说法，不同分区实际上都被统一挂载到根目录下的不同文件夹中。

Q：熟悉Linux的基本命令，可以⽤markdown做⼀些笔记或者速查表。

A：
| 命令 | 作用 | 示例 |
| --- | --- | --- |
| `ls` | 列出目录内容 | `ls -la` |
| `cd` | 切换目录 | `cd /home` |
| `mkdir` | 创建目录 | `mkdir test` |
| `rm -rf` | 删除目录及内容 | `rm -rf test` |
| `touch` | 创建空文件 | `touch file.txt` |
| `cp` | 复制文件/目录 | `cp a.txt b.txt` |
| `mv` | 移动/重命名 | `mv a.txt /tmp/` |
| `cat` | 查看文件内容 | `cat file.txt` |
| `tail -f` | 实时查看日志 | `tail -f /var/log/syslog` |
| `id` | 查看 UID/GID | `id` |
| `su` | 切换用户 | `su root` |
| `sudo` | 管理员执行命令 | `sudo apt update` |
| `chmod` | 修改权限 | `chmod 755 file.sh` |
| `chown` | 修改所有者 | `chown user:group file.txt` |
| `ps aux` | 查看进程 | `ps aux | grep ssh` |
| `top` | 动态进程（个人喜欢用htop软件包代替） | `top` |
| `kill -9` | 杀死进程 | `kill -9 1234` |
| `df -h` | 磁盘使用情况 | `df -h` |
| `du -sh` | 查看目录大小 | `du -sh /var/log` |
| `free -h` | 内存使用情况 | `free -h` |
| `uptime` | 系统运行时间 | `uptime` |
| `shutdown -h now` | 立即关机 | `shutdown -h now` |
| `reboot` | 重启系统 | `reboot` |
| `ping` | 测试网络 | `ping baidu.com` |
| `ifconfig` / `ip addr` | 查看网卡信息 | `ip addr` |
| `curl` | 获取网页内容 | `curl https://example.com` |
| `wget` | 下载文件 | `wget https://example.com/file.zip` |
| `ssh` | 远程登录 | `ssh user@192.168.1.10` |
| `find` | 查找文件 | `find / -name file.txt` |
| `grep` | 搜索关键字 | `grep "root" /etc/passwd` |
| `which` | 查找命令位置 | `which python3` |

Q：熟悉⼀下包管理器。

A：Linux的包管理器主要分为以下类别：deb系（Debian和基于此的发行版，包括Ubuntu）、rpm系（Red Hat的发行版，比如Fedora、RHEL、CentOS）、pacman系（Arch和基于此的发行版，比如Manjaro）、其他（比如Nix）。

对于deb系，包管理器的常用命令如下：

| 命令 | 作用 |
| --- | --- |
| `sudo apt update` | 刷新软件源 |
| `sudo apt upgrade` | 升级软件包 |
| `sudo apt install 包名` | 安装软件包（可同时安装多个软件包） |
| `sudo apt install 包名=版本号` | 安装指定版本的软件包 |
| `sudo apt reinstall 包名` | 重新安装软件包 |
| `sudo apt remove 包名` | 卸载软件包 |
| `sudo apt purge 包名` | 卸载软件包和配置文件 |
| `apt list --installed` | 查看已安装的软件 |
| `apt list --upgradable` | 查看可升级的软件 |
| `apt search 关键词` | 搜索软件包 |
| `apt show 包名` | 查看软件包的详细信息 |
| `sudo apt autoremove` | 自动删除不再需要的依赖包 |
| `sudo apt autoclean` | 删除旧版的软件包缓存 |
| `sudo apt clean` | 删除所有下载的软件包缓存 |

另外，还有个更高级的软件包管理器`aptitude`，在面临依赖冲突的时候是一个很方便的东西。

Q：配置⼀个自己喜欢的shell。

A：Ubuntu最初的shell是bash。
```bash
~$ echo $SHELL
/bin/bash
```

这里打算配置zsh。首先输入`apt install zsh curl git -y`安装zsh、curl、git三个软件包，命令执行完成后使用`chsh -s /bin/zsh`切换默认sh为zsh，再关闭终端，重新打开一个新的终端，并创建一个新的空白配置文件。

然后安装oh-my-zsh。在终端中输入`sh -c "$(curl -fsSL https://gitee.com/pocmon/ohmyzsh/raw/master/tools/install.sh)"`并执行（使用gitee源）来安装它。

安装结束后，使用`git clone --depth=1 https://gitee.com/romkatv/powerlevel10k.git "${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k"`（gitee源）下载powerlevel10k的主题包，再编辑`~/.zshrc`中`ZSH_THEME`一项的值为`powerlevel10k/powerlevel10k`切换为对应的主题包，最后使用`source ~/.zshrc`刷新一下，就能进入powerlevel10k的主题设置页面。根据提示设置结束之后就能正常使用了。

现在的效果：![zsh效果图](51.png)

## Task3

Q：简单了解⼀下ssh协议。

A：ssh协议用于在公开网络下安全地登录和执行命令。它使用了公钥加密技术和对称密钥加密技术，前者用于安全地交换密钥，后者用于加密实际传输的数据。

在使用ssh时，客户端和服务器之间会进行公钥交换，然后客户端会使用服务器的公钥加密要传输的数据，然后将加密后的数据发送到服务器。服务器使用自己的私钥解密数据，然后将数据返回给客户端。所有的数据在传输时都是加密的，从而保证了数据的安全性。另外ssh还有数据完整性校验，保证了数据的完整性。

以上特点也是ssh有别于telnet（明文）等协议的不同点。

Q： 尝试在⾃⼰的Linux虚拟机/服务器上下载openssh并使用ssh连接。

A：使用`sudo apt install openssh-server -y`安装服务端，命令执行结束后使用`ip addr`命令找到虚拟机的ip地址：
```bash
~$ ip addr
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host noprefixroute
       valid_lft forever preferred_lft forever
2: ens33: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc fq_codel state UP group default qlen 1000
    link/ether 00:0c:29:e4:a6:98 brd ff:ff:ff:ff:ff:ff
    altname enp2s1
    inet 192.168.110.43/24 brd 192.168.110.255 scope global dynamic noprefixroute ens33
       valid_lft 649sec preferred_lft 649sec
    inet6 fe80::20c:29ff:fee4:a698/64 scope link
       valid_lft forever preferred_lft forever
```
我的虚拟机的ip地址是`192.168.110.43`。现在可以在主机的命令行中使用`ssh {用户名}@{虚拟机ip地址}`连接虚拟机（Win11应该已经内置了ssh）。询问是否同意连接时输入`yes`并回车。输出如下：
```bash
~$ ssh test-user@192.168.110.43
The authenticity of host '192.168.110.43 (192.168.110.43)' can't be established.
ED25519 key fingerprint is SHA256:impwHfh8HGKZeulaRuTHHJVLiBN0mPqB3CNDhBXA4SE.
This key is not known by any other names.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '192.168.110.43' (ED25519) to the list of known hosts.
test-user@192.168.110.43's password:
Welcome to Ubuntu 24.04.3 LTS (GNU/Linux 6.14.0-33-generic x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/pro

扩展安全维护（ESM）Applications 未启用。

56 更新可以立即应用。
要查看这些附加更新，请运行：apt list --upgradable

11 个额外的安全更新可以通过 ESM Apps 来获取安装。
可通过以下途径了解如何启用 ESM Apps：at https://ubuntu.com/esm


The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

test-user@test:~$
```

Q：尝试⼀下免密登录。

A：首先现在自己的电脑上生成一对密钥。

```bash
~$ ssh-keygen -t rsa
Generating public/private rsa key pair.
Enter file in which to save the key (~/.ssh/id_rsa):
~/.ssh/id_rsa already exists.
Overwrite (y/n)? y
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in ~/.ssh/id_rsa
Your public key has been saved in ~/.ssh/id_rsa.pub
The key fingerprint is:
SHA256:xxx/xxx xxx@xxx
The key's randomart image is:
+---[RSA 3072]----+
|adcfvybuhjmxdrcfv|
|wdwcfvgbhunfvgbhd|
|dwazwsecrfdcfvtgg|
|dcftvubfghbjnvgbh|
|fgvhbghbjirtyucvb|
|cfvgbgvbhtvyguhis|
|sxdrcftvdrfvtgbhh|
|drfvtgftgygygcdfv|
|zsxedrcftdcrftfvt|
+----[SHA256]-----+
```

接下来把生成的密钥复制到目标Linux服务器上。如果是Windows系统，建议在Git Bash中操作。
```bash
~$ ssh-copy-id test-user@192.168.110.43
/usr/bin/ssh-copy-id: INFO: Source of key(s) to be installed: "/c/Users/Administrator/.ssh/id_rsa.pub"
/usr/bin/ssh-copy-id: INFO: attempting to log in with the new key(s), to filter out any that are already installed
/usr/bin/ssh-copy-id: INFO: 1 key(s) remain to be installed -- if you are prompted now it is to install the new keys
test-user@192.168.110.43's password:

Number of key(s) added: 1

Now try logging into the machine, with: "ssh 'test-user@192.168.110.43'"
and check to make sure that only the key(s) you wanted were added.
```

现在就能实现免密登录了。此时在主机中使用`ssh test-user@192.168.110.43`即能直接进入Linux服务器的终端，不再需要输入密码。

如果仍然需要密码，尝试在Linux终端中使用`sudo systemctl restart ssh`重启ssh。

Q：尝试再⽣成⼀对ssh密钥，把公钥交给你的github管理，使⽤ssh协议来操
作git。

A：在Windows系统中，当你安装了Git后，应该就能使用一个叫Git GUI的软件，也可以使用它来生成密钥。
![Git GUI](52.png)
根据图中箭头打开菜单栏中的“Help”中的“Show SSH Key”项，就会打开这样的页面：
![Show SSH Key](53.png)
先点击“Generate Key”生成一对密钥，然后点击“Copy To Clipboard”把生成的密钥复制到剪贴板，然后点击“Close”关闭窗口。

然后打开[Github的SSH密钥设置](https://github.com/settings/keys)页面，在SSH密钥分类处点击新建，然后把刚才复制的密钥粘贴到“Key”下方的文本框中，再填写标题（可选），最后点击最下方的按钮即可完成添加。

此时在你的主机的终端中输入`ssh -T git@github.com`，如果返回这样的字样，说明已经ssh授权成功。
```bash
Hi xxx! You've successfully authenticated, but GitHub does not provide shell access.
```
此时我们就可以使用ssh操作git了。比如使用`git clone git@github.com:DenvoZonis/glimmerTest.git`来把我的交题的仓库整个克隆下来。

Q：使用其他连接工具？

A：我在Windows系统上主要使用FinalShell，在Android系统上主要使用terminus。