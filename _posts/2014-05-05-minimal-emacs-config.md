Title: Minimal Emacs Config
Date: 2014-05-05 21:00
Tags: emacs, gists, editors, programming

I love the versatility of emacs, even without any additional packages. You get
a powerful and fast editing environment that is ridiculously extendable if you
so desire.

I used to maintain quite an extensive `.emacs` configuration, with all sorts
of third party packages and custom functions. But early this year, after about
a year of heavy Emacs use, I felt the pain of maintaining a working,
organized, and fast Emacs setup was just too much. After a certain threshold,
twiddling around editor configuration for hours seems to look awfully like
useless bike-shedding. And I did find myself sinking a couple hours at a time
on my `.emacs` and `.emacs.d`. "Time for a fucking change," I thought.

So, I took an axe to my `.emacs`. I made a very minimal configuration that
distilled my previous learnings into a simple collection of basic overrides.
The basics are all there, and the remaining annoyances require too big of an
investment of effort over a long time to be worth it for me.

A bonus of this minimal config is that `emacs` is instantaneous, even without
the whole "run emacs as a daemon and connect to it" shenanigans.

(I must admit that lately I've dropped even this in favor of Sublime Text 3 +
[sublemacspro](https://github.com/grundprinzip/sublemacspro)).

But anyway, here's my minimal config (also
[here as this gist](https://gist.github.com/gnarmis/d8ce3d817bb16a65a0b7)):


    ; Want a fast emacs startup? Copy this to ~/.emacs.minimal and:
    ;
    ;   cp ~/.emacs ~/.emacs.bak
    ;   echo "(load-file \"/absolute/path/to/.emacs.minimal\")" > ~/.emacs
    ;
    ; Switch it back if you don't like it.
    ;

    ;; cutoff for word wrap
    (setq-default fill-column 79)

    ;; F12 toggles auto-fill mode
    (global-set-key [f12] 'auto-fill-mode)

    ;; C-- keybinding for undo (removes the shift)
    (global-set-key [(control -)] 'undo)

    ;; turn on pending delete (when a region
    ;; is selected, typing replaces it)
    (delete-selection-mode t)

    ;; when on a tab, make the cursor the tab length
    (setq-default x-stretch-cursor t)

    ;; avoid garbage collection (default is only 400k)
    (setq-default gc-cons-threshold 4000000)

    ;; twiddle miscellaneous customization options
    (custom-set-variables
      '(sentence-end-double-space nil)
      '(truncate-partial-width-windows nil)
      '(line-number-mode t)
      '(column-number-mode t)
      '(query-user-mail-address nil)
      '(visible-bell t))

    ;; prevent creation of backup files. I'd rather manually handle that.
    (setq make-backup-files nil)

    ;; set indentation to 2
    (setq standard-indent 2)

    ;; set newline as required for every file's last line
    (setq require-final-newline nil)

    ;; freaking don't ask me to type out "yes" and "no"
    (defalias 'yes-or-no-p 'y-or-n-p)

    ;; Prevent the cursor from blinking
    (blink-cursor-mode 0)

    ;; Don't use messages that you don't read
    (setq initial-scratch-message "")
    (setq inhibit-startup-message t)

    ;; key binding for fill-region
    (global-set-key (kbd "C-c f") 'fill-region)

    ;; disable color crap that pukes up everywhere
    (setq-default global-font-lock-mode nil)
