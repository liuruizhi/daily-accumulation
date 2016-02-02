git test for myself.
git commit -m "".
#添加并commit，省去add操作
git commit -a -m ""
#查看日志
git log
#只显示一行
git log --pretty=oneline
#退出log用q
#回退到某个版本(^表示上一个，^^再上一个，那100次？HEAD~100)
git reset --hard HEAD^
#回退之后还可以再回到某个当前版本，前提是命令窗口没关（下面的数字是版本号头几位，没必要全写）
git reset --hard 32456
#但是如果关了命令窗口也有办法（git提供后悔药）
git reflog
#创建分支
git checkout -b name
#等同于以下两条
git branch name#创建分支
git checkout name#切换分支
#合并分支
git merge name
#删除分支
git branch -d name
#git冲突必须手动解决
#查看提交日志路径
git log --graph --pretty=oneline --abbrev-commit
#创建临时储存点 -- 有临时任务需要切换分支时可以将当前内容存储起来
git stash

====
merger